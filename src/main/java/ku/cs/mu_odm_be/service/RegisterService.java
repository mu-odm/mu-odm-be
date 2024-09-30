package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.User;
import ku.cs.mu_odm_be.repository.UserRepository;
import ku.cs.mu_odm_be.request.RegisterRequest;
import ku.cs.mu_odm_be.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public boolean isEmailAvailable(String email) {
        return userRepository.findByEmail(email) == null;
    }


    public void createUser(RegisterRequest req) {
        User user = modelMapper.map(req, User.class);
        user.setRole("ROLE_SALESMAN");

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
