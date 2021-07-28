package com.example.restservice.controllers;

import com.example.restservice.Book;
import com.example.restservice.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookDAO bookDAO;

    @Autowired
    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public List<Book> showAllBooks() {
        return bookDAO.index();
    }

    @GetMapping("/{id}")
    public Book showBookByID(@PathVariable("id") long id) {
        return bookDAO.getBook(id);
    }

    @PostMapping("/add")
    public List<Book> addBook(@RequestBody Book book) {

        bookDAO.addBook(book.getTitle(), book.getAuthor(), book.getGenre());

        return showAllBooks();
    }

    @PutMapping("/edit/{id}")
    public List<Book> editBookByID(@PathVariable("id") long id, @RequestBody Book editedBookParam) {

        Book editingBook = bookDAO.getBook(id);

        if (editingBook != null) {
            editingBook.setTitle(editedBookParam.getTitle());
            editingBook.setAuthor(editedBookParam.getAuthor());
            editingBook.setGenre(editedBookParam.getGenre());
        }

        return showAllBooks();
    }

    @DeleteMapping("/delete/{id}")
    public List<Book> deleteBookByID(@PathVariable(value = "id") long id) {

        bookDAO.removeBook(id);

        return showAllBooks();
    }
}
