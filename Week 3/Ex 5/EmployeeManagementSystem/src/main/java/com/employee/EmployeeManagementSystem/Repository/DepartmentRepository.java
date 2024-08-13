package com.employee.EmployeeManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.EmployeeManagementSystem.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query(name = "Department.GetIdByName")
    int GetIdByName(@Param("name")String name);
}
