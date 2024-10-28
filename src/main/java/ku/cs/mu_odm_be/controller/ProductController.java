package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.request.ProductRequest;
import ku.cs.mu_odm_be.response.ProductResponse;
import ku.cs.mu_odm_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product")
    public ProductResponse getProduct(@RequestParam UUID id) {
        return productService.getProduct(id);
    }

    @PutMapping("/product")
    public ProductResponse updateProduct(@RequestParam UUID productID, @RequestBody ProductRequest prod) {
        return productService.updateProduct(productID, prod);
    }

    @GetMapping("/name")
    public List<ProductResponse> getProductByName(@RequestParam String name) {
        return productService.getProductByName(name);
    }
}
