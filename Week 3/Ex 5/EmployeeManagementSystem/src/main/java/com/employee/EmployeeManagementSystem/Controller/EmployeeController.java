package com.employee.EmployeeManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.employee.EmployeeManagementSystem.Entity.Employee;
import com.employee.EmployeeManagementSystem.Repository.EmployeeRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("employee")
    public Employee addEmployeeDb(@RequestBody Employee employee) {        
        return employeeRepository.save(employee);
    }

    @GetMapping("employee")
    public List<Employee> getEmployeeDb() {
        return employeeRepository.findAll();
    }
    
    @PutMapping("employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeDetails) {
        return (ResponseEntity<Employee>) employeeRepository.findById(id)
            .map(employee -> {
                employee.setName(employeeDetails.getName());
                employee.setEmail(employeeDetails.getEmail());
                employee.setDepartment(employeeDetails.getDepartment());
                return ResponseEntity.ok(employeeRepository.save(employee));
            })
            .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("employee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Integer id) {
        return employeeRepository.findById(id)
            .map(employee -> {
                employeeRepository.delete(employee);
                return ResponseEntity.ok().build();
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
