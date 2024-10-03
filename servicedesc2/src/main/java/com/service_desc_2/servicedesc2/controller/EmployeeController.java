package com.service_desc_2.servicedesc2.controller;

import com.service_desc_2.servicedesc2.entity.Employee;
import com.service_desc_2.servicedesc2.service.EmployeeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/get")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @PostMapping("/{employeeId}/assign-role/{roleId}")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public void assignRole(@PathVariable Long employeeId, @PathVariable Long roleId) {
        employeeService.assignRole(employeeId, roleId);
    }
}