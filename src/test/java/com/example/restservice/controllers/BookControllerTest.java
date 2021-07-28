package com.example.restservice.controllers;

import com.example.restservice.Book;
import com.example.restservice.dao.BookDAO;
import com.example.restservice.repository.BookRepository;
import com.example.restservice.services.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
@MockBean(BookDAO.class)
@MockBean(BookRepository.class)
class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookServiceImpl bookService;

    @Test
    public void showAllBooks() throws Exception {
        Book testBook_0 = new Book(1, "test_1", "test_2", "test_3");
        Book testBook_1 = new Book(2, "test_2", "test_3", "test_4");
        Book testBook_2 = new Book(3, "test_3", "test_4", "test_5");

        List<Book> messageList = Arrays.asList(testBook_0, testBook_1, testBook_2);

        given(bookService.getAllBooks()).willReturn(messageList);

        mvc.perform(get("/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void showBookByID() {
    }

    @Test
    void addBook() {
    }

    @Test
    void addManyBooks() {
    }

    @Test
    void editBookByID() {
    }

    @Test
    void deleteBookByID() {
    }
}