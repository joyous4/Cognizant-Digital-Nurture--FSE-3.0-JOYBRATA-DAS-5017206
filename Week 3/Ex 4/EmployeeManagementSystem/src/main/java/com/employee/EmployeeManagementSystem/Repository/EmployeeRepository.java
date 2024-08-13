package com.employee.EmployeeManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.EmployeeManagementSystem.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //derived
    List<Employee> findByEmail(String email);
}
