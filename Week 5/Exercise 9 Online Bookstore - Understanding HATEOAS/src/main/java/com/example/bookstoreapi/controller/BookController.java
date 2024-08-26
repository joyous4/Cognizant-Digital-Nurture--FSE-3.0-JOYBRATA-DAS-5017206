package com.example.bookstoreapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.mapper.BookMapper;
import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.service.BookService;

//BookController class defined to test the REST Endpoints
@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    //BookController class updated with the usage of BookDTO Data Transfer Objects as part of Excercise 7
    
    //BookController class updated with EntityModel and Link classes to add Hateoas for API documentation as required by Excercise 9
    @GetMapping
    public ResponseEntity<List<EntityModel<BookDTO>>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        List<EntityModel<BookDTO>> bookDTOs = books.stream()
                .map(book -> {
                    BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDTO(book);
                    Link selfLink = linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel();
                    bookDTO.add(selfLink);
                    return EntityModel.of(bookDTO);
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<BookDTO>> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDTO(book);
        Link selfLink = linkTo(methodOn(BookController.class).getBookById(id)).withSelfRel();
        bookDTO.add(selfLink);
        return ResponseEntity.ok(EntityModel.of(bookDTO));
    }

    @PostMapping
    public ResponseEntity<EntityModel<BookDTO>> createBook(@Valid @RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.bookDTOToBook(bookDTO);
        Book createdBook = bookService.createBook(book);
        BookDTO createdBookDTO = BookMapper.INSTANCE.bookToBookDTO(createdBook);
        Link selfLink = linkTo(methodOn(BookController.class).getBookById(createdBook.getId())).withSelfRel();
        createdBookDTO.add(selfLink);
        return ResponseEntity.status(201).body(EntityModel.of(createdBookDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<BookDTO>> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
        Book bookDetails = BookMapper.INSTANCE.bookDTOToBook(bookDTO);
        Book updatedBook = bookService.updateBook(id, bookDetails);
        BookDTO updatedBookDTO = BookMapper.INSTANCE.bookToBookDTO(updatedBook);
        Link selfLink = linkTo(methodOn(BookController.class).getBookById(updatedBook.getId())).withSelfRel();
        updatedBookDTO.add(selfLink);
        return ResponseEntity.ok(EntityModel.of(updatedBookDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
    
    //BookController updated with @search endpoint to display the CRUD operations
    @GetMapping("/search")
    public List<Book> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {
        if (title != null && author != null) {
            return bookService.getBooksByTitleAndAuthor(title, author);
        } else if (title != null) {
            return bookService.getBooksByTitle(title);
        } else if (author != null) {
            return bookService.getBooksByAuthor(author);
        } else {
            return bookService.getAllBooks();
        }
    }
}
