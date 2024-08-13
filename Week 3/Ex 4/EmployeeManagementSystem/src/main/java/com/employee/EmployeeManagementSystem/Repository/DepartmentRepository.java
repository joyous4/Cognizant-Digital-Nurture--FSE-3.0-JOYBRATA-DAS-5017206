package com.employee.EmployeeManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.EmployeeManagementSystem.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
