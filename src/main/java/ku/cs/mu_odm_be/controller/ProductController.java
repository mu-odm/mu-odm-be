package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.entity.Product;
import ku.cs.mu_odm_be.request.ProductRequest;
import ku.cs.mu_odm_be.response.ProductResponse;
import ku.cs.mu_odm_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest req, BindingResult result) {
        return productService.createProduct(req);
    }

    @PutMapping("/id")
    public ProductResponse updateProduct(@RequestParam UUID id, @RequestBody Product prod) {
        return productService.updateProduct(prod);
    }
}
