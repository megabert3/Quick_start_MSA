package com.example.restservice.controllers;

import com.example.restservice.Book;
import com.example.restservice.services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookServiceImpl bookService;

    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> showAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book showBookByID(@PathVariable("id") long id) {
        return bookService.getBook(id);
    }

    @PostMapping("/add")
    public List<Book> addBook(@RequestBody Book book) {

        bookService.addBook(book);

        return showAllBooks();
    }

    @PutMapping("/edit/{id}")
    public List<Book> editBookByID(@PathVariable("id") long id, @RequestBody Book editedBookParam) {

        bookService.editBook(id, editedBookParam);

        return showAllBooks();
    }

    @DeleteMapping("/delete/{id}")
    public List<Book> deleteBookByID(@PathVariable(value = "id") long id) {

        bookService.removeBook(id);

        return showAllBooks();
    }
}
