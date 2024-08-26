package com.example.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreapi.model.Customer;

@Repository
//Since we defined Customer Entity.......
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
