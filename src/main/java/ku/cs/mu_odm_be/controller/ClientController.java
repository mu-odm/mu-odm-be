package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.entity.Client;
import ku.cs.mu_odm_be.entity.Salesman;
import ku.cs.mu_odm_be.service.ClientService;
import ku.cs.mu_odm_be.service.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private SalesmanService salesmanService;

    @PostMapping("ref/{salesman_id}")
    public Client createClient(@PathVariable UUID saleman_id, @RequestBody Client client) {
        Salesman salesman = salesmanService.findById(saleman_id);
        client.setSalesman(salesman);
        return clientService.createClient(client);
    }
}
