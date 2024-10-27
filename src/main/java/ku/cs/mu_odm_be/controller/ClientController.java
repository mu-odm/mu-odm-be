package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.request.ClientRequest;
import ku.cs.mu_odm_be.response.ClientResponse;
import ku.cs.mu_odm_be.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ClientResponse createClient(@RequestBody ClientRequest req, BindingResult result) {

        if (result.hasErrors())
            return null;

        return clientService.createClient(req);
    }

    @GetMapping
    public List<ClientResponse> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/client")
    public ClientResponse getClient(@RequestParam UUID id) {
        return clientService.getClient(id);
    }

    @GetMapping("/email")
    public ClientResponse getClientByEmail(@RequestParam String email) {
        return clientService.getClientByEmail(email);
    }

}
