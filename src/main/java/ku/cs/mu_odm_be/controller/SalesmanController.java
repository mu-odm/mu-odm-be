package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.request.SalesmanRequest;
import ku.cs.mu_odm_be.service.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salesmen")
public class SalesmanController {

    @Autowired
    private SalesmanService salesmanService;

    @PostMapping
    public SalesmanRequest createSalesman(
            @RequestHeader(value = "Authorization", required = true) String authToken,
            @RequestBody SalesmanRequest req,
            BindingResult result
    ) {

        if (result.hasErrors())
            return null;

        return salesmanService.createSalesman(req, authToken);
    }

}
