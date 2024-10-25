package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.request.PurchaseProductRequest;
import ku.cs.mu_odm_be.response.PurchaseProductResponse;
import ku.cs.mu_odm_be.service.ClientService;
import ku.cs.mu_odm_be.service.ProductService;
import ku.cs.mu_odm_be.service.OrderService;
import ku.cs.mu_odm_be.service.PurchaseProductService;
import ku.cs.mu_odm_be.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase_product")
public class PurchaseProductController {

    @Autowired
    private PurchaseProductService purchaseProductService;

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    ClientService clientService;

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @PostMapping
    public PurchaseProductResponse purchase (@RequestBody PurchaseProductRequest req) {
        return purchaseProductService.purchase(req);
    }
}