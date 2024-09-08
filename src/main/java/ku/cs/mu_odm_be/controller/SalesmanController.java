package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.entity.Salesman;
import ku.cs.mu_odm_be.service.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salesmen")
public class SalesmanController {

    @Autowired
    private SalesmanService salesmanService;

    @PostMapping
    public Salesman createSalesman(@RequestBody Salesman salesman) {
        return salesmanService.createSalesman(salesman);
    }

}
