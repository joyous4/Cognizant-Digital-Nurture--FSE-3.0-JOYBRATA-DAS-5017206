package com.library.service;

public class BookService {
	private int BookID;
	private String BookName;
	
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
	@Override
	public String toString() {
		return "BookService [BookID=" + BookID + ", BookName=" + BookName + "]";
	}
	
}
