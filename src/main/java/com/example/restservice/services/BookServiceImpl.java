package com.example.restservice.services;

import com.example.restservice.Book;
import com.example.restservice.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookDAO bookDAO;

    @Autowired
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.index();
    }

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void editBook(long id, Book book) {
        bookDAO.editById(id, book);
    }

    @Override
    public Book getBook(long id) {
        return bookDAO.getBook(id);
    }

    @Override
    public void removeBook(long id) {
        bookDAO.removeBook(id);
    }


}
