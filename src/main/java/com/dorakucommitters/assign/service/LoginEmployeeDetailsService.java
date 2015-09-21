package com.dorakucommitters.assign.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dorakucommitters.assign.domain.Employee;
import com.dorakucommitters.assign.repository.EmployeeRepository;

@Service
public class LoginEmployeeDetailsService implements UserDetailsService
{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        List<Employee> employees = this.employeeRepository.findOnebyLoginId(username);
        if ((employees == null) || (employees.isEmpty() || (employees.size() > 1))
        ) {
            throw new UsernameNotFoundException("The requested user is not found.");
        }
        return new LoginEmployeeDetails(employees.get(0));
    }

}
