package com.example.restservice;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    protected Book() { }

    public Book(long id, String title, String autor, String genre) {
        this.id = id;
        this.title = title;
        this.author = autor;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Book book = (Book) obj;

        return this.getId() == book.getId() &&
                this.getAuthor().equals(book.getAuthor()) &&
                this.getGenre().equals(book.getGenre()) &&
                this.getTitle().equals(book.getTitle());
    }

    @Override
    public String toString() {
        return String.format("Название книги: %s, автор: %s, жанр: %s", title, author, genre);
    }
}
