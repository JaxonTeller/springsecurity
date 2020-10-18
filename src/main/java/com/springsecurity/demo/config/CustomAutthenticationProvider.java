package com.springsecurity.demo.config;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.security.AuthProvider;
import java.util.Arrays;
import java.util.List;

@Component
public class CustomAutthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //provide own authentication logic here
        String userName=authentication.getName();
        String password=String.valueOf(authentication.getCredentials());

        if(userName.equals("NewUser") && password.equals("NewPassword"))
        {
            return new UsernamePasswordAuthenticationToken(userName,password, Arrays.asList());
        }
        else
        {
            throw new AuthenticationCredentialsNotFoundException("Username or password is incorrect");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
         return UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(aClass);
    }
}
