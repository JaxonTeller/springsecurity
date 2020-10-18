package com.springsecurity.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@RequiredArgsConstructor
public class UserDetailsSerivceConfig extends WebSecurityConfigurerAdapter {

    /*This will autowire the UserDetailsConfig*/
    private final UserDetails userDetails;

//    @Bean
//    public UserDetailsService getUserDetails()
//    {
//        var userDetailsService=new InMemoryUserDetailsManager(userDetails);
//        return userDetailsService;
//    }

    @Bean
    public UserDetailsService getUserDetails()
    {
        /*Using the Spring provided implementation of UserDetails, which is User*/
        UserDetails userDetails = User.withUsername("User").password("Password").authorities("READ").build();
        var userDetailsService=new InMemoryUserDetailsManager(this.userDetails);
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }
}
