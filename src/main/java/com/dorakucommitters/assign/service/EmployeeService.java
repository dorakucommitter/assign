package com.dorakucommitters.assign.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dorakucommitters.assign.domain.Employee;
import com.dorakucommitters.assign.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAllOrderByName();
    }

    public Employee findOne(Integer id) {
        return employeeRepository.findOne(id);
    }


    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(Integer id) {
        employeeRepository.delete(id);
    }
}
