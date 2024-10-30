package ku.cs.mu_odm_be.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import ku.cs.mu_odm_be.common.PurchasApproval;
import ku.cs.mu_odm_be.common.Status;
import ku.cs.mu_odm_be.entity.*;
import ku.cs.mu_odm_be.repository.*;
import ku.cs.mu_odm_be.request.PurchaseProductRequest;
import ku.cs.mu_odm_be.response.PurchaseProductResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PurchaseProductService {
    @Autowired
    private PurchaseProductRepository purchaseProductRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    public Purchase getCurrentPurchase(UUID cID, User user){
        Order order = orderService.getExistOrder(Status.Available, user.getRegion());
        if (order == null){
            order = orderService.createOrder(user);
        }

        Purchase purchase = purchaseService.getPurchaseByOrderIdAndClientId(
                order.getId(),
                cID
        );

        if (purchase == null || purchase.getStatus() != PurchasApproval.Pending){
            Purchase newPurchase = new Purchase();
            newPurchase.setOrder(order);
            newPurchase.setClient(clientRepository.findById(cID).get());
            newPurchase.setCreated_at(new java.sql.Timestamp(System.currentTimeMillis()));
            newPurchase.setStatus(PurchasApproval.Pending);
            purchase = purchaseRepository.save(newPurchase);
        }

        return purchase;
    }

    private String decodeJWT(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getSubject();
    }

    public PurchaseProductResponse purchase(PurchaseProductRequest req, String authorizationHeader){

        String token = authorizationHeader.substring(7);
        String sub = decodeJWT(token);

        User user = userRepository.findByEmail(sub);
        Product product = productRepository.findByid(req.getProductID());

        if (product.getStatus() != Status.Available){
            throw new RuntimeException("Product is not available");
        }

        Purchase purchase = getCurrentPurchase(req.getClientID(), user);

        PurchaseProduct purchaseProduct = new PurchaseProduct();
        purchaseProduct.setId(new PurchaseProductKey(purchase.getId(), product.getId()));
        purchaseProduct.setAmount(req.getAmount());
        purchaseProduct.setProduct(product);
        purchaseProduct.setPurchase(purchase);

        if (product.getRemaining() < req.getAmount()){
            throw new RuntimeException("Not enough stock");
        }

        purchaseProduct.setPps_id(req.getPps_id());

        purchaseProductRepository.save(purchaseProduct);
        return modelMapper.map(purchaseProduct, PurchaseProductResponse.class);
    }

    public List<PurchaseProductResponse> getAllPurchaseProduct(){
        List<PurchaseProduct> purchaseProducts = purchaseProductRepository.findAll();
        return purchaseProducts.stream()
                .map(purchaseProduct -> modelMapper.map(purchaseProduct, PurchaseProductResponse.class))
                .toList();
    }


}
