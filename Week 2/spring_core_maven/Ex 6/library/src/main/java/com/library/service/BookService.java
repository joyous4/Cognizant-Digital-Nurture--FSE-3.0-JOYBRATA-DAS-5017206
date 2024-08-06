package com.library.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.repository.BookRepository;

@Service
public class BookService {
	private int BookID;
	private String BookName;
	
	@Autowired
	private BookRepository bookRepo;
	
	public BookRepository getBookRepo() {
		return bookRepo;
	}
	public void setBookRepo(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String someMethod() {
        System.out.println("BookService is working!");
        return bookRepo.someRepositoryMethod(); 
    }
	
	@Override
	public String toString() {
		return "BookService [BookID=" + BookID + ", BookName=" + BookName + ", bookRepo=" + bookRepo.toString() + "]";
	}
	
}
