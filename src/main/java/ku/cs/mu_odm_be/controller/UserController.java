package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.response.UserResponse;
import ku.cs.mu_odm_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/email")
    public  UserResponse getUserByEmail(@RequestParam String email) {
        return userService.findUserByEmail(email);
    }

}
