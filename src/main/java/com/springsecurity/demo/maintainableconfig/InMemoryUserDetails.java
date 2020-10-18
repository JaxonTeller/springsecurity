package com.springsecurity.demo.maintainableconfig;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserDetails implements UserDetailsService {

    private List<UserDetails> users=new ArrayList<>();

    public InMemoryUserDetails(List<UserDetails> users)
    {
        this.users.addAll(users);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //for ex: while login we can take user name and check if user is present in database
        //or not, if not usernotfoundexception is thrown.else user is returned.
        System.out.println("Called by Spring");
        return users.stream().
                filter(userDetails -> userDetails.getUsername().equals(name)).
                findFirst().orElseThrow(()->new UsernameNotFoundException("User Not Found"));
    }

}
