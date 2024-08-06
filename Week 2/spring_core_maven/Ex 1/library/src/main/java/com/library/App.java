package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.repository.BookRepository;
import com.library.service.BookService;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	BookRepository bookRepo = (BookRepository) context.getBean("Repo");
    	BookService bookService = (BookService) context.getBean("Servc");
    	
        System.out.println( bookRepo );
        System.out.println( bookService );
    }
}
