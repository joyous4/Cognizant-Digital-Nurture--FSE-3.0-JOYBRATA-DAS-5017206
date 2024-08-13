package com.ems.EmployeeManagementSystem.repository;

import com.ems.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

        List<Employee> findByName(String name);
//
//    List<Employee> findByDepartment(int departmentId);
//
//    List<Employee> findByEmailContaining(String email);
//
//    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
//    List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByNameContaining(String name, Pageable pageable);
}