package com.springsecurity.demo.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*This class is an implementation of  UserDetails*/
@Component
public class UserDetailsConfig implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities=List.of(new SimpleGrantedAuthority("READ"));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return "Password";
    }

    @Override
    public String getUsername() {
        return "User";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
