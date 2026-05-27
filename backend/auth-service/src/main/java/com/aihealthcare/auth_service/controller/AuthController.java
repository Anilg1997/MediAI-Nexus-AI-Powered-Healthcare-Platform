package com.aihealthcare.auth_service.controller;

import com.aihealthcare.auth_service.dto.LoginRequest;
import com.aihealthcare.auth_service.dto.RegisterRequest;
import com.aihealthcare.auth_service.entity.User;
import com.aihealthcare.auth_service.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(
            @Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest request) {

        return authService.login(request);
    }

    @GetMapping("/admin")
    public String admin() {

        return "Welcome Admin";
    }

    @GetMapping("/profile")
    public String profile() {

        return "Welcome Authenticated User";
    }
}