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

    @Autowired
    private PPSRepository ppsRepository;

    public Purchase getCurrentPurchase(UUID cID, User user){
        Order order = orderService.getExistOrder(Status.Available, user.getRegion());
        if (order == null){
            order = orderService.createOrder(user);
        }

        List<Purchase> purchases = purchaseService.getPurchaseByOrderIdAndClientId(
                order.getId(),
                cID
        );

        Purchase purchase = null;
        for (Purchase p : purchases){
            if (p.getStatus() == PurchasApproval.Pending){
                purchase = p;
                break;
            }
        }

        if (purchase == null){
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
        PPS pps = ppsRepository.findById(new PPSKey(req.getProduct_id(), req.getProduct_size_id())).get();

        if (pps.getStatus() != Status.Available){
            throw new RuntimeException("Product is not available");
        }

        Purchase purchase = getCurrentPurchase(req.getClientID(), user);

        PPSKey ppsKey = new PPSKey(req.getProduct_id(), req.getProduct_size_id());

        PurchaseProduct purchaseProduct = new PurchaseProduct();
        purchaseProduct.setId(new PurchaseProductKey(purchase.getId(), ppsKey));
        purchaseProduct.setAmount(req.getAmount());
        purchaseProduct.setPurchase(purchase);
        purchaseProduct.setClientID(req.getClientID());

        if (pps.getRemaining() < req.getAmount()){
            throw new RuntimeException("Not enough stock");
        }

        purchaseProduct.setPps(ppsRepository.findById(ppsKey).get());

        purchaseProductRepository.save(purchaseProduct);
        PurchaseProductResponse res = modelMapper.map(purchaseProduct, PurchaseProductResponse.class);
        res.setClientID(req.getClientID());
        return res;
    }

    public List<PurchaseProductResponse> getAllPurchaseProduct(){
        List<PurchaseProduct> purchaseProducts = purchaseProductRepository.findAll();
        return purchaseProducts.stream()
                .map(purchaseProduct -> modelMapper.map(purchaseProduct, PurchaseProductResponse.class))
                .toList();
    }


}
