package com.dorakucommitters.assign.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dorakucommitters.assign.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Page<Employee> findAll(Pageable pageable);

    @Query("SELECT x FROM Employee x ORDER BY x.employee_id, x.name")
    List<Employee> findAllOrderByName();

    @Query("SELECT x FROM Employee x ORDER BY x.employee_id, x.name")
    Page<Employee> findAllOrderByName(Pageable pageable);
}
