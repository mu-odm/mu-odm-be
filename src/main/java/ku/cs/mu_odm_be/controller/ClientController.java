package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.entity.Client;
import ku.cs.mu_odm_be.request.ClientRequest;
import ku.cs.mu_odm_be.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public Client createClient(@RequestBody ClientRequest req, BindingResult result) {

        if (result.hasErrors())
            return null;

        return clientService.createClient(req);
    }

}
