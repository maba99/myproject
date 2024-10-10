package com.service_desc_2.servicedesc2.service;

import com.service_desc_2.servicedesc2.entity.Employee;
import com.service_desc_2.servicedesc2.repository.EmployeeRepository;
import com.service_desc_2.servicedesc2.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;


    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createEmployee() {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setEmail("john@example.com");
        employee.setPosition("Developer");

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee createdEmployee = employeeService.createEmployee(employee);

        assertNotNull(createdEmployee);
        assertEquals("John Doe", createdEmployee.getName());
    }

    @Test
    void getAllEmployees() {
        Employee employee1 = new Employee();
        employee1.setName("John Doe");

        Employee employee2 = new Employee();
        employee2.setName("Jane Doe");

        when(employeeRepository.findAll()).thenReturn(List.of(employee1, employee2));

        List<Employee> employees = employeeService.getAllEmployees();

        assertEquals(2, employees.size());
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("John Doe");

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee updatedEmployee = employeeService.updateEmployee(1L, employee);

        assertNotNull(updatedEmployee);
        assertEquals("John Doe", updatedEmployee.getName());
    }

    @Test
    void deleteEmployee() {
        Long employeeId = 1L;
        doNothing().when(employeeRepository).deleteById(employeeId);

        assertDoesNotThrow(() -> employeeService.deleteEmployee(employeeId));
        verify(employeeRepository, times(1)).deleteById(employeeId);
    }

//    @Test
//    @WithMockUser(roles = "SUPERADMIN") // Эмулируем пользователя с ролью суперпользователя
//    void assignRole() {
//        Employee employee = new Employee();
//        employee.setId(1L);
//        employee.setRoles(new HashSet<>());
//
//        Role role = new Role();
//        role.setId(1L);
//        role.setName("USER");
//
//        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
//        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
//
//        employeeService.assignRole(1L, 1L);
//
//        assertTrue(employee.getRoles().contains(role));
//    }
}
