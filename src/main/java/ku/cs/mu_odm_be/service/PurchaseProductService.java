package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.common.Status;
import ku.cs.mu_odm_be.entity.*;
import ku.cs.mu_odm_be.repository.*;
import ku.cs.mu_odm_be.request.PurchaseProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ClientService clientService;

    public Purchase getCurrentPurchase(UUID cID){
        Order order = orderService.findByStatus(Status.available);
        if (order == null){
            order = orderService.createOrder();
        }

        Purchase purchase = purchaseService.findPurchaseByOrderIdAndClientId(
                order.getId(),
                cID
        );

        if (purchase == null){
            System.out.println("purchase not found");
            Purchase newPurchase = new Purchase();
            newPurchase.setOrder(order);
            newPurchase.setClient(clientService.findById(cID));
            purchase = purchaseRepository.save(newPurchase);
        }

        return purchase;
    }

    public PurchaseProductRequest purchase(PurchaseProductRequest req){

        Purchase purchase = getCurrentPurchase(req.getClientID());
        Product product = productRepository.findByid(req.getProductID());

        PurchaseProduct purchaseProduct = new PurchaseProduct();
        purchaseProduct.setId(new PurchaseProductKey(purchase.getId(), product.getId()));
        purchaseProduct.setAmount(req.getAmount());
        purchaseProduct.setProduct(product);
        purchaseProduct.setPurchase(purchase);

        purchaseProductRepository.save(purchaseProduct);
        return req;
    }


}
