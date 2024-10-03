package com.service_desc_2.servicedesc2.controller;

import com.service_desc_2.servicedesc2.entity.Role;
import com.service_desc_2.servicedesc2.service.RoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @GetMapping("/get")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
}
