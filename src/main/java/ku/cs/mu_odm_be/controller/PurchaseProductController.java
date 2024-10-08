package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.entity.Order;
import ku.cs.mu_odm_be.entity.Product;
import ku.cs.mu_odm_be.entity.PurchaseProduct;
import ku.cs.mu_odm_be.request.OrderRequest;
import ku.cs.mu_odm_be.entity.Purchase;
import ku.cs.mu_odm_be.request.ProductRequest;
import ku.cs.mu_odm_be.request.PurchaseProductRequest;
import ku.cs.mu_odm_be.request.PurchaseRequest;
import ku.cs.mu_odm_be.service.ClientService;
import ku.cs.mu_odm_be.service.ProductService;
import ku.cs.mu_odm_be.service.OrderService;
import ku.cs.mu_odm_be.service.PurchaseProductService;
import ku.cs.mu_odm_be.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @PostMapping("/{product}")
    public PurchaseProduct purchase(@RequestBody PurchaseProductRequest req) {
        return purchaseProductService.purchase(req);
    }
}
