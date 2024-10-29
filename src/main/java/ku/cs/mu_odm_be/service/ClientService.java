package ku.cs.mu_odm_be.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import ku.cs.mu_odm_be.entity.Client;
import ku.cs.mu_odm_be.entity.User;
import ku.cs.mu_odm_be.repository.ClientRepository;
import ku.cs.mu_odm_be.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    private String decodeJWT(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getSubject();
    }

    public ClientResponse createClient(ClientRequest req, String authorizationHeader) {
        Client client = modelMapper.map(req, Client.class);

        if (clientRepository.existsByEmail(client.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        String token = authorizationHeader.substring(7);
        String sub = decodeJWT(token);

        User user = userRepository.findByEmail(sub);
        client.setUser(user);

        clientRepository.save(client);
        ClientResponse response = modelMapper.map(client, ClientResponse.class);
        response.setUser_id(user.getId());
        return response;
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

    public ClientResponse updateClient(String email, ClientRequest req) {
        Client client = clientRepository.findByEmail(email);
        client.setDeferStatus(req.isDeferStatus());
        return modelMapper.map(clientRepository.save(client), ClientResponse.class);
    }
}
