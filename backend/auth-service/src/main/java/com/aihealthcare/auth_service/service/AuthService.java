package com.aihealthcare.auth_service.service;

import com.aihealthcare.auth_service.dto.LoginRequest;
import com.aihealthcare.auth_service.dto.RegisterRequest;
import com.aihealthcare.auth_service.entity.User;
import com.aihealthcare.auth_service.jwt.JwtService;
import com.aihealthcare.auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String register(RegisterRequest request) {

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        user.setPassword(
                passwordEncoder.encode(request.getPassword()));

        user.setRole("USER");

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public String login(LoginRequest request) {

        Optional<User> user =
                userRepository.findByEmail(request.getEmail());

        if (user.isPresent()) {

            if (passwordEncoder.matches(
                    request.getPassword(),
                    user.get().getPassword())) {

                return jwtService.generateToken(
                        user.get().getEmail());
            }
        }

        return "Invalid Email or Password";
    }
}