package com.example.restservice.controllers;

import com.example.restservice.Book;
import com.example.restservice.services.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookServiceImpl bookService;

    private final Book testBook = new Book(0, "test_1", "test_2", "test_3");
    private final List<Book> bookList = Arrays.asList(testBook);

    @Test
    void showAllBooks() throws Exception {
        when(bookService.getAllBooks()).thenReturn(bookList);

        mockMvc.perform(get("/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is(testBook.getTitle())))
                .andExpect(jsonPath("$[0].author", is(testBook.getAuthor())))
                .andExpect(jsonPath("$[0].genre", is(testBook.getGenre())));
    }

    @Test
    void showBookByID() throws Exception {
        when(bookService.getBook(testBook.getId())).thenReturn(testBook);

        mockMvc.perform(get("/books/{id}", 0)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(testBook.getId()), Long.class))
                .andExpect(jsonPath("$.title", is(testBook.getTitle())))
                .andExpect(jsonPath("$.author", is(testBook.getAuthor())))
                .andExpect(jsonPath("$.genre", is(testBook.getGenre())));
    }
}