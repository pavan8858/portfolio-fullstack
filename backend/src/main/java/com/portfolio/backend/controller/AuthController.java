package com.portfolio.backend.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.entity.User;
import com.portfolio.backend.repository.UserRepository;

import com.portfolio.backend.security.JwtUtill;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtill jwtUtil; 

    public AuthController(UserRepository userRepository,
                          BCryptPasswordEncoder encoder,
                          JwtUtill jwtUtil) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }
     

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("ROLE_ADMIN");

        return ResponseEntity.ok(userRepository.save(user));
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {

        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return ResponseEntity.ok(
                Map.of(
                    "token", token,
                    "username", user.getUsername(),
                    "role", user.getRole()
                )
        );
    }

}
