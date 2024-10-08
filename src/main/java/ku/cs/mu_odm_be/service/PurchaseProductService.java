package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.common.Status;
import ku.cs.mu_odm_be.entity.*;
import ku.cs.mu_odm_be.repository.*;
import ku.cs.mu_odm_be.request.OrderRequest;
import ku.cs.mu_odm_be.request.PurchaseProductRequest;
import ku.cs.mu_odm_be.request.PurchaseRequest;
import org.modelmapper.ModelMapper;
import org.springdoc.core.service.RequestBodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PurchaseService purchaseService;

    public Purchase getCurrentPurchase(UUID cID){
//        Order currentOrder = orderRepository.findByStatus(Status.available);
//        if(currentOrder == null){
//            OrderRequest req = new OrderRequest();
//            req.setStatus(Status.available);
//            currentOrder = orderService.createOrder(req);
//        }
//        Purchase currentPurchase = purchaseRepository.findByClientId(clientID);
//        if(currentPurchase == null && !currentOrder.getStatus().equals(Status.available)){
//            PurchaseRequest req = new PurchaseRequest();
//            req.setClient_id(clientID);
//            req.setOrder_id(currentOrder.getId());
//            currentPurchase = purchaseService.creatPurchase(req);
//        }
//        return currentPurchase;
        Purchase currentPurchase = purchaseService.findPurchaseByClientId(cID);

        if(currentPurchase == null){
            PurchaseRequest req = new PurchaseRequest();
            req.setClient_id(cID);
        }
//        Order currentOrder = currentPurchase.
        if(currentOrder == null){}
    }

    public PurchaseProduct purchase(PurchaseProductRequest req){

        Purchase purchase = getCurrentPurchase(req.getPurchaseId());
        Product product = productRepository.findByid(req.getProductId());

        PurchaseProduct purchaseProduct = new PurchaseProduct();
        purchaseProduct.setProduct(product);
        purchaseProduct.setPurchase(purchase);
        purchaseProduct.setAmount(req.getAmount());

        return purchaseProductRepository.save(purchaseProduct);
    }


}
