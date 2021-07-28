package com.example.restservice.services;

import com.example.restservice.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    void addBook(Book book);

    Book getBook(long id);

    void removeBook(long id);

    void editBook(long id, Book book);
}
