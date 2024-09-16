package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.entity.ProductSize;
import ku.cs.mu_odm_be.entity.Salesman;
import ku.cs.mu_odm_be.service.ProductSizeService;
import ku.cs.mu_odm_be.service.SalesmanService;
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
    public ProductSize createProductSize(@RequestBody ProductSize productSize) {return productSizeService.createProductSize(productSize);}
}
