package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Client;
import ku.cs.mu_odm_be.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

}
