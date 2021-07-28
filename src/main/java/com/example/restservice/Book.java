package com.example.restservice;

public class Book {

    private final long id;

    private String title;

    private String author;

    private String genre;

    public Book(long id, String title, String autor, String genre) {
        this.id = id;
        this.title = title;
        this.author = autor;
        this.genre = genre;
    }

    public long getId() {
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
}
