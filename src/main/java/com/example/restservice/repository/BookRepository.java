package com.example.restservice.repository;

import com.example.restservice.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    List<Book> findByGenre(String genre);
    Book findByTitle(String title);
    Book findById(long Id);
}
