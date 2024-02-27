package com.contact.manager.config;

import com.contact.manager.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    // this is a user details class which will extract user details from db
    // next create a implementation class of this details class
    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getUser_password();
    }
    @Override
    public String getUsername() {
        // in this case we'll use email as username
        return user.getUser_email();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getUser_role());

        return List.of(simpleGrantedAuthority);
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
