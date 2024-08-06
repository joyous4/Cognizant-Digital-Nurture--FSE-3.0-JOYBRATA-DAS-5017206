package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

	private int BookID;
	private String BookName;
	private BookRepository bookRepo;
	
	public BookService(int bookID, String bookName, BookRepository bookRepo) {
		super();
		BookID = bookID;
		BookName = bookName;
		this.bookRepo = bookRepo;
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
