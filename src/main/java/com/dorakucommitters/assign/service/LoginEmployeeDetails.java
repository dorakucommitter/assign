package com.dorakucommitters.assign.service;

import org.springframework.security.core.authority.AuthorityUtils;

import com.dorakucommitters.assign.domain.Employee;

import lombok.Data;

@Data
public class LoginEmployeeDetails extends org.springframework.security.core.userdetails.User
{
    private final Employee employee;

    public LoginEmployeeDetails(Employee employee)
    {
        super(employee.getName(), employee.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.employee = employee;
    }

    public Employee getEmployee()
    {
        return this.employee;
    }

}
