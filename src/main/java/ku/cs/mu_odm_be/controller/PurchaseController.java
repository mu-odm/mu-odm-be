package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.entity.Client;
import ku.cs.mu_odm_be.entity.Purchase;
import ku.cs.mu_odm_be.entity.Product;
import ku.cs.mu_odm_be.service.ClientService;
import ku.cs.mu_odm_be.service.PurchaseService;
import ku.cs.mu_odm_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/Purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    ProductService productService;

    @Autowired
    ClientService clientService;

    @PostMapping("/ref/{products_id}")
    public Purchase createPurchase(@PathVariable UUID products_id, @RequestParam UUID clients_id, @RequestBody Purchase purchase) {
        Product product = productService.findById(products_id);
        Client client = clientService.findById(clients_id);

        // Create a set to store products and add the single product to it
        Set<Product> products = purchase.getProducts();
        if (products == null) {
            products = new HashSet<>();
        }
        products.add(product);

        purchase.setProducts(products); // Now setting the set of products
        purchase.setClient(client);

        // Save the purchase using purchaseService
        return purchaseService.creatPurchase(purchase);
    }
    }
}
