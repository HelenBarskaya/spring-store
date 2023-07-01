package com.example.mystore.service;

import com.example.mystore.MyStoreApplication;
import com.example.mystore.model.User;
import com.example.mystore.repository.UserRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@EnableAutoConfiguration
public class JpaUserDetailsService extends MyStoreApplication implements UserDetailsService {
    UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(this::userMapper)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
    }

    protected User userMapper(User user) {
        String password = user.getPassword();
        user.setPassword("{noop}" + password);

        return user;
    }
}