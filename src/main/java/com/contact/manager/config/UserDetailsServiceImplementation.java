package com.contact.manager.config;

import com.contact.manager.dao.UserRepository;
import com.contact.manager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String user_email) throws UsernameNotFoundException {

        User userByEmail = userRepository.getUserByEmail(user_email);
        if (userByEmail==null){
            throw new UsernameNotFoundException("Could not found user !!");
        }

        return new CustomUserDetails(userByEmail);
    }
}
