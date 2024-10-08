package com.service_desc_2.servicedesc2.service.impl;

import com.service_desc_2.servicedesc2.entity.Employee;

import java.util.List;

public interface EmployeeServiceImpl {
    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
    void assignRole(Long employeeId, Long roleId);
}