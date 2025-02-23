package com.sda.demo.service;

import com.sda.demo.adapter.UserDetailsAdapter;
import com.sda.demo.model.User;
import com.sda.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        User foundUser = user.orElseThrow(() -> new UsernameNotFoundException("Error! Username not found"));
        return new UserDetailsAdapter(foundUser);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}
