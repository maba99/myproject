package com.service_desc_2.servicedesc2.service;

import com.service_desc_2.servicedesc2.entity.Employee;
import com.service_desc_2.servicedesc2.entity.Role;
import com.service_desc_2.servicedesc2.repository.EmployeeRepository;
import com.service_desc_2.servicedesc2.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;

    public EmployeeService(EmployeeRepository employeeRepository, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Long id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void assignRole(Long employeeId, Long roleId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        Role role = roleRepository.findById(roleId).orElseThrow();

        // Проверка на наличие роли SUPERADMIN
        if (employee.getRoles().stream().anyMatch(r -> r.getName().equals("SUPERADMIN"))) {
            employee.getRoles().add(role);
            employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Only superadmin can assign roles");
        }
    }
}