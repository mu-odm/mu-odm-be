package ku.cs.mu_odm_be.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import ku.cs.mu_odm_be.entity.Salesman;
import ku.cs.mu_odm_be.entity.User;
import ku.cs.mu_odm_be.repository.SalesmanRepository;
import ku.cs.mu_odm_be.repository.UserRepository;
import ku.cs.mu_odm_be.request.SalesmanRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanRepository salesmanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public SalesmanRequest createSalesman(SalesmanRequest req, String authToken) {
        Salesman salesman = modelMapper.map(req, Salesman.class);

        if (authToken.startsWith("Bearer ")) {
            authToken = authToken.substring(7);
        }

        DecodedJWT decodedJWT = JWT.decode(authToken);
        String email = decodedJWT.getSubject();
        System.out.println(decodedJWT.getSubject());

        String role = decodedJWT.getClaim("role").asString();

        if (!role.equals("SALESMAN"))
            return null;

        User user = userRepository.findByEmail(email);

        if (user == null)
            return null;

        user.setSalesman(salesman);
        salesman.setUser(user);
        salesman.setName(user.getUsername());
        salesmanRepository.save(salesman);
        return req;
    }

    public Salesman findSalesmanByID(UUID id) {
        return salesmanRepository.findById(id).get();
    }
}
