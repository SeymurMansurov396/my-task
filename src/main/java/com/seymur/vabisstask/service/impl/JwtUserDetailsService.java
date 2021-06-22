package com.seymur.vabisstask.service.impl;


import com.seymur.vabisstask.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;


    public JwtUserDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.seymur.vabisstask.model.User userFromDB = null;
        try {
            com.seymur.vabisstask.model.User userByUsername = userRepository.findAllByUsernameAndIsEnabled(username,1);
            if (userByUsername!=null) {
                userFromDB = userByUsername;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (userFromDB != null) {
            if (userFromDB.getIsEnabled() == 0) {
                throw new UsernameNotFoundException("User  with username: " + username + " is not active");
            }
            List<GrantedAuthority> authorities = new ArrayList<>();

            User user = new User(userFromDB.getUsername(), userFromDB.getPassword(), authorities);
            return user;
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
