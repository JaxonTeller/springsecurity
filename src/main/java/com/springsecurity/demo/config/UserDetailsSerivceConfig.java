package com.springsecurity.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@RequiredArgsConstructor
public class UserDetailsSerivceConfig {

    private final UserDetails userDetails;

    @Bean
    public UserDetailsService getUserDetails()
    {
        var userDetailsService=new InMemoryUserDetailsManager(userDetails);
        return userDetailsService;
    }
}
