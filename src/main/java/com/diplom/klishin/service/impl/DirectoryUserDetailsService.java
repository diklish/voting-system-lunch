package com.diplom.klishin.service.impl;

import com.diplom.klishin.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DirectoryUserDetailsService implements UserDetailsService {

    private UserRepository repo;

    public DirectoryUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            final com.diplom.klishin.model.User user = this.repo.findByEmailIgnoreCase(username);

            if (user != null) {
                PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
                String password = encoder.encode(user.getPassword());

                return org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).accountLocked(!user.isActive()).password(password).roles(user.getRoles().toString()).build();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        throw new UsernameNotFoundException(username);
    }
}
