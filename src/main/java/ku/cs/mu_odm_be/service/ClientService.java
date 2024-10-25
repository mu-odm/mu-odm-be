package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Client;
import ku.cs.mu_odm_be.repository.ClientRepository;
import ku.cs.mu_odm_be.request.ClientRequest;
import ku.cs.mu_odm_be.response.ClientResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Autowired
    private ModelMapper modelMapper;

    public ClientResponse createClient(ClientRequest req) {
        Client client = modelMapper.map(req, Client.class);
        clientRepository.save(client);
        return modelMapper.map(client, ClientResponse.class);
    }

    public Client findById(UUID id) {
        return clientRepository.findById(id).orElse(null);
    }
}
