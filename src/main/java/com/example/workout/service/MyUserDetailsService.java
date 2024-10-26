package com.example.workout.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.workout.model.UserPrincipal;
import com.example.workout.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Loading user with username {}", username);
        UserDetails user = userRepository.findByUsername(username).map(UserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));

        logger.info("Found user with username {}", username);
        return user;
    }

}
