package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.entity.Product;
import ku.cs.mu_odm_be.entity.ProductSize;
import ku.cs.mu_odm_be.service.ProductService;
import ku.cs.mu_odm_be.service.ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductSizeService productSizeService;

    @PostMapping("ref/{productSize_id}")
    public Product createProduct(@PathVariable UUID productSize_id, @RequestBody Product product) {
        ProductSize productSize = productSizeService.findById(productSize_id);
        product.setProductSize(productSize);
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable UUID id, @RequestBody Product productDetails) {
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
        if (productDetails.getAvailable() >= 0) {  //boolean 0 - 1
            existingProduct.setAvailable(productDetails.getAvailable());
        }

        return productService.updateProduct(existingProduct);
    }
}
