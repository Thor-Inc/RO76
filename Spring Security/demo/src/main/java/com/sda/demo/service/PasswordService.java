package com.sda.demo.service;

import com.sda.demo.adapter.UserDetailsAdapter;
import com.sda.demo.model.User;
import com.sda.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class PasswordService implements UserDetailsPasswordService {

    private final UserRepository userRepository;

    public PasswordService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        Optional<User> userCredentials =
                userRepository.findByUsername(user.getUsername());
        if (userCredentials.isPresent()) {
            userCredentials.get().setPassword(newPassword);
        }
        return new UserDetailsAdapter(userCredentials.get());
    }
}
