package com.springsecurity.demo.maintainableconfig;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserDetailsServiceCheck implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //for ex: while login we can take user name and check if user is present in database
        //or not, if not usernotfoundexception is thrown.else user is returned.
        return null;
    }

}
