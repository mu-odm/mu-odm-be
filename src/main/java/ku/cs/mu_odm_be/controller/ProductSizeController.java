package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.request.ProductSizeRequest;
import ku.cs.mu_odm_be.response.ProductSizeResponse;
import ku.cs.mu_odm_be.service.ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product_size")
public class ProductSizeController {

    @Autowired
    private ProductSizeService productSizeService;

    @PostMapping
    public ProductSizeResponse createProductSize(@RequestBody ProductSizeRequest req) {return productSizeService.createProductSize(req);}

    @GetMapping("/product")
    public List<ProductSizeResponse> getProductSize(@RequestParam UUID productID) {return productSizeService.getProductSize(productID);}

    @DeleteMapping("/product_size")
    public void deleteProductSize(@RequestParam UUID id) {productSizeService.deleteProductSize(id);}

}
