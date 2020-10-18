package com.springsecurity.demo.maintainableconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/*This class will single responsibility of managing the User*/
@Configuration
public class UserMangementConfig {

    /*We are using bean appraoch, instead of extending WebSecurityConfigAdaptor and using AuthenticationManagementBuilder as
    * we want to use this beans for injections.*/
    @Bean
    public UserDetailsService provideUserDetailsService()
    {
        UserDetails userDetails = User.withUsername("User").password("Password").authorities("READ").build();
        UserDetailsService userDetailsService=new InMemoryUserDetailsManager(userDetails);
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder providePasswordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }

}
