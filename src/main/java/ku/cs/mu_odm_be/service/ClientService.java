package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Client;
import ku.cs.mu_odm_be.entity.Salesman;
import ku.cs.mu_odm_be.repository.ClientRepository;
import ku.cs.mu_odm_be.request.ClientRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SalesmanService salesmanService;

    @Autowired
    private ModelMapper modelMapper;

    public Client createClient(ClientRequest req) {
        Client client = modelMapper.map(req, Client.class);
        Salesman salesman = salesmanService.findSalesmanByID(req.getSalesman_id());
        client.setSalesman(salesman);
        clientRepository.save(client);
        return client;
    }

    public Client findById(UUID id) {
        return clientRepository.findById(id).orElse(null);
    }
}
