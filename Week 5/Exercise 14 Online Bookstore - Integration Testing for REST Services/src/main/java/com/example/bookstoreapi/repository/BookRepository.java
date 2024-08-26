package com.example.bookstoreapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreapi.model.Book;

//BookRepository class created to implement JPA Repository methods
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	//Custom query added to the book repository interface according to Excercise 3 
	List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(String title, String author);
}