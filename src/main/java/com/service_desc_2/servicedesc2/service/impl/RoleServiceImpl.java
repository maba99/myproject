package com.service_desc_2.servicedesc2.service.impl;

import com.service_desc_2.servicedesc2.entity.Role;

import java.util.List;

public interface RoleServiceImpl {
    Role createRole(Role role);
    List<Role> getAllRoles();
}