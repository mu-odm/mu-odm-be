package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.entity.Salesman;
import ku.cs.mu_odm_be.request.SalesmanRequest;
import ku.cs.mu_odm_be.service.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public Salesman createSalesman(@RequestBody SalesmanRequest req, BindingResult result) {

        if (result.hasErrors())
            return null;

        return salesmanService.createSalesman(req);
    }

}
