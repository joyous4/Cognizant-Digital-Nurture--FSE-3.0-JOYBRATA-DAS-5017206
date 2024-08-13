package com.ems.EmployeeManagementSystem.service;

import com.ems.EmployeeManagementSystem.model.Employee;
import com.ems.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

//    public Page<Employee> findByNameContaining(String name, Pageable pageable) {
//        return employeeRepository.findByNameContaining(name, pageable);
//    }

    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}