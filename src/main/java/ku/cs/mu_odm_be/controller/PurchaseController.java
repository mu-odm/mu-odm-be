//package ku.cs.mu_odm_be.controller;
//
//import ku.cs.mu_odm_be.entity.Purchase;
//import ku.cs.mu_odm_be.request.PurchaseRequest;
//import ku.cs.mu_odm_be.service.ClientService;
//import ku.cs.mu_odm_be.service.OrderService;
//import ku.cs.mu_odm_be.service.PurchaseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/purchase")
//public class PurchaseController {
//
//    @Autowired
//    PurchaseService purchaseService;
//
//    @Autowired
//    ClientService clientService;
//
//    @Autowired
//    OrderService orderService;
//
//    @PostMapping
//    public Purchase createPurchase(@RequestBody PurchaseRequest req) {
//        return purchaseService.creatPurchase(req);
//    }
//}
