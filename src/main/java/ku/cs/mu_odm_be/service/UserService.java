package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.User;
import ku.cs.mu_odm_be.repository.UserRepository;
import ku.cs.mu_odm_be.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    // User
    public List<UserResponse> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserResponse.class)).toList();
    }

    public UserResponse findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return modelMapper.map(user, UserResponse.class);
    }
}
