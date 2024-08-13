package com.ems.EmployeeManagementSystem.repository;

import com.ems.EmployeeManagementSystem.dto.DepartmentDTO;
import com.ems.EmployeeManagementSystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    // Interface-based projection
    List<DepartmentProjection> findAllProjectedBy();

    @Query("SELECT d.id AS id, d.name AS name FROM Department d")
    List<DepartmentProjection> findCustomProjectedBy();

    // Class-based projection
    @Query("SELECT new com.example.DepartmentDTO(d.id, d.name) FROM Department d")
    List<DepartmentDTO> findAllDepartmentDTOs();
}