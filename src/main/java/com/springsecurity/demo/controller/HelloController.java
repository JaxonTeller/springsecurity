package com.springsecurity.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.message.config.AuthConfigProvider;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello()
    {
        return ResponseEntity.ok().toString();
    }
}
