package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.entity.Product;
import ku.cs.mu_odm_be.request.ProductRequest;
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
    public ProductRequest createProduct(@RequestBody ProductRequest req, BindingResult result) {
        return productService.createProduct(req);
    }

    @PutMapping("/id")
    public Product updateProduct(@RequestParam UUID id, @RequestBody Product productDetails) {
        Product existingProduct = productService.findById(id);
        if (existingProduct == null) {
            throw new IllegalArgumentException("Product not found with id: " + id);
        }

        if (productDetails.getName() != null) {
            existingProduct.setName(productDetails.getName());
        }
        if (productDetails.getPrice() != 0) {
            existingProduct.setPrice(productDetails.getPrice());
        }

        return productService.updateProduct(existingProduct);
    }
}
