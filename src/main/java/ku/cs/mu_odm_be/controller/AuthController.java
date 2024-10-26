package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.config.JwtProvider;
import ku.cs.mu_odm_be.entity.User;
import ku.cs.mu_odm_be.repository.UserRepository;
import ku.cs.mu_odm_be.request.RegisterRequest;
import ku.cs.mu_odm_be.response.AuthResponse;
import ku.cs.mu_odm_be.service.RegisterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private RegisterService registerService;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest req) {
        if (userRepository.existsByEmail(req.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already taken!");
        }

        User user = modelMapper.map(req, User.class);
        user.setRole("SALESMAN");

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody RegisterRequest req) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        User user = registerService.findUserByEmail(authenticate.getName());
        String token = jwtProvider.generateToken(user);
        return ResponseEntity.ok(
                new AuthResponse(token, user)
        );

    }
}