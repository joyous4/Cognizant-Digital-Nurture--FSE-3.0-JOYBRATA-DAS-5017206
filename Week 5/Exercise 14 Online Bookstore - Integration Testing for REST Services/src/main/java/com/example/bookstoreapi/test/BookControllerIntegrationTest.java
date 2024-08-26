package com.example.bookstoreapi.test;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
@Transactional

//This class is set for Integration Testing as required by Excercise 14
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        bookRepository.deleteAll(); 
    }

    @Test
    public void testGetBooks() throws Exception {
        BookDTO book1 = new BookDTO(null, "Title1", "Author1", 19.99, "ISBN123");
        bookRepository.save(new Book(book1.getTitle(), book1.getAuthor(), book1.getPrice(), book1.getIsbn()));

        mockMvc.perform(get("/api/books")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Title1"));
    }

    @Test
    public void testCreateBook() throws Exception {
        BookDTO bookDTO = new BookDTO(null, "New Book", "New Author", 39.99, "ISBN789");

        mockMvc.perform(post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("New Book"));
    }
    
    @Test
    public void testDeleteBook() throws Exception {
        BookDTO bookDTO = new BookDTO(null, "Delete Book", "Author", 29.99, "ISBN456");
        Book savedBook = bookRepository.save(new Book(bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getPrice(), bookDTO.getIsbn()));

        mockMvc.perform(delete("/api/books/{id}", savedBook.getId()))
                .andExpect(status().isNoContent());
        
        mockMvc.perform(get("/api/books/{id}", savedBook.getId()))
                .andExpect(status().isNotFound());
    }

}
