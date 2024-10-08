package com.service_desc_2.servicedesc2.service;

import com.service_desc_2.servicedesc2.entity.User;
import com.service_desc_2.servicedesc2.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    void createUser() {
        User user = new User();
        user.setUsername("john_doe");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(user);

        assertNotNull(createdUser);
        assertEquals("john_doe", createdUser.getUsername());
    }

    @Test
    void getAllUsers() {
        User user1 = new User();
        user1.setUsername("john_doe");

        User user2 = new User();
        user2.setUsername("jane_doe");

        when(userRepository.findAll()).thenReturn(List.of(user1, user2));

        List<User> users = userService.getAllUsers();

        assertEquals(2, users.size());
    }
}
