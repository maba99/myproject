package com.service_desc_2.servicedesc2.service.impl;

import com.service_desc_2.servicedesc2.entity.User;

import java.util.List;

public interface UserServiceImpl {
    User createUser(User user);
    List<User> getAllUsers();
}