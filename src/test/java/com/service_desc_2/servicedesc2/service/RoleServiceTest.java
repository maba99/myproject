package com.service_desc_2.servicedesc2.service;

import com.service_desc_2.servicedesc2.entity.Role;
import com.service_desc_2.servicedesc2.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RoleServiceTest {

    private RoleRepository roleRepository;
    private RoleService roleService;

    @BeforeEach
    void setUp() {
        roleRepository = mock(RoleRepository.class);
        roleService = new RoleService(roleRepository);
    }

    @Test
    void createRole() {
        Role role = new Role();
        role.setName("USER");

        when(roleRepository.save(any(Role.class))).thenReturn(role);

        Role createdRole = roleService.createRole(role);

        assertNotNull(createdRole);
        assertEquals("USER", createdRole.getName());
    }

    @Test
    void getAllRoles() {
        Role role1 = new Role();
        role1.setName("USER");

        Role role2 = new Role();
        role2.setName("ADMIN");

        when(roleRepository.findAll()).thenReturn(List.of(role1, role2));

        List<Role> roles = roleService.getAllRoles();

        assertEquals(2, roles.size());
    }
}
