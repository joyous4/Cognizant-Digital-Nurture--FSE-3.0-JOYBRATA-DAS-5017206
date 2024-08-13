package com.ems.EmployeeManagementSystem.service;

import com.ems.EmployeeManagementSystem.model.Employee;
import com.ems.EmployeeManagementSystem.repository.EmployeeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void batchInsertEmployees(List<Employee> employees) {
        Session session = sessionFactory.getCurrentSession();
        for (int i = 0; i < employees.size(); i++) {
            session.save(employees.get(i));
            if (i % 20 == 0) { // Batch size
                session.flush();
                session.clear();
            }
        }
    }

    @Transactional
    public void batchUpdateEmployees(List<Employee> employees) {
        Session session = sessionFactory.getCurrentSession();
        for (int i = 0; i < employees.size(); i++) {
            session.update(employees.get(i));
            if (i % 20 == 0) { // Batch size
                session.flush();
                session.clear();
            }
        }
    }
}