package com.service_desc_2.servicedesc2.security;

import com.service_desc_2.servicedesc2.entity.Employee;
import com.service_desc_2.servicedesc2.repository.EmployeeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    public CustomUserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmail(username)
                .orElseThrow(() -> {
                    System.out.println("User not found: " + username); // Логирование
                    return new UsernameNotFoundException("User not found");
                });
        return JwtUserDetails.build(employee);
    }
}