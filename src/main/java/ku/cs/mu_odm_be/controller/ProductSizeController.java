package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.request.ProductSizeRequest;
import ku.cs.mu_odm_be.service.ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product_size")
public class ProductSizeController {

    @Autowired
    private ProductSizeService productSizeService;

    @PostMapping
    public ProductSizeRequest createProductSize(@RequestBody ProductSizeRequest req) {return productSizeService.createProductSize(req);}
}
