package com.example.restservice.dao;

import com.example.restservice.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDAO {

    private static List<Book> books = new ArrayList<>();

    private static long BOOK_ID = 0;

    public BookDAO() {
        books.add(new Book(++BOOK_ID,
                "О дивный новый мир",
                "Олдос Леонард Хаксли",
                "Классическая художественная проза")
        );

        books.add(new Book(
                ++BOOK_ID,
                "Триумфальная арка",
                "Эрих Ремарк",
                "Роман"
        ));

        books.add(new Book(
                ++BOOK_ID,
                "Мартин Иден",
                "Джек Лондон",
                "Роман"
        ));
    }

    public List<Book> index() {
        return books;
    }

    public void addBook(String title,String author, String genre) {
        books.add(new Book(++BOOK_ID,title, author, genre));
    }

    public Book getBook(long id) {
        return books.stream().filter(book -> book.getId() == id).findAny().orElse(null);
    }

    public void removeBook(long id) {
        Book remove = books.stream().filter(book -> book.getId() == id).findAny().orElse(null);

        if (remove != null)
            books.remove(remove);
    }
}
