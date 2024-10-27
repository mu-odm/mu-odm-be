package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Client;
import ku.cs.mu_odm_be.repository.ClientRepository;
import ku.cs.mu_odm_be.request.ClientRequest;
import ku.cs.mu_odm_be.response.ClientResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Autowired
    private ModelMapper modelMapper;

    public ClientResponse createClient(ClientRequest req) {
        Client client = modelMapper.map(req, Client.class);

        if (clientRepository.existsByEmail(client.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        clientRepository.save(client);
        return modelMapper.map(client, ClientResponse.class);
    }

    public ClientResponse getClient(UUID id) {
        return modelMapper.map(clientRepository.findById(id).get(), ClientResponse.class);
    }

    public List<ClientResponse> getAllClients() {
        return modelMapper.map(clientRepository.findAll(), List.class);
    }

    public ClientResponse getClientByEmail(String email) {
        return modelMapper.map(clientRepository.findByEmail(email), ClientResponse.class);
    }
}
