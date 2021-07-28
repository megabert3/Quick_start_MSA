package com.example.restservice.dao;

import com.example.restservice.Book;
import com.example.restservice.repository.BookRepository;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDAO {

    private final BookRepository bookRepository;

    public BookDAO(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> index() {
        return Lists.newArrayList(bookRepository.findAll());
    }

    public void addBook(Book book) {

        bookRepository.save(book);
    }

    public Book getBook(long id) {
        return bookRepository.findById(id);
    }

    public void removeBook(long id) {
        bookRepository.deleteById(id);
    }

    public void editById(long id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            bookRepository.save(book);
        }
    }


    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
