package com.ems.EmployeeManagementSystem.repository;

import com.ems.EmployeeManagementSystem.dto.EmployeeDTO;
import com.ems.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Interface-based projection
    List<EmployeeProjection> findAllProjectedBy();
    @Query("SELECT e.id AS id, e.name AS name, e.email AS email, e.department.name AS departmentName FROM Employee e")
    List<EmployeeProjection> findCustomProjectedBy();

    // Class-based projection
    @Query("SELECT new com.example.EmployeeDTO(e.id, e.name, e.email, e.department.name) FROM Employee e")
    List<EmployeeDTO> findAllEmployeeDTOs();
}