package com.service_desc_2.servicedesc2.service;

import com.service_desc_2.servicedesc2.entity.Role;
import com.service_desc_2.servicedesc2.repository.RoleRepository;
import com.service_desc_2.servicedesc2.service.impl.RoleServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements RoleServiceImpl {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}