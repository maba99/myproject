package com.service_desc_2.servicedesc2.service;

import com.service_desc_2.servicedesc2.repository.UserRepository;
import com.service_desc_2.servicedesc2.entity.User;
import com.service_desc_2.servicedesc2.service.impl.UserServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceImpl {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
