package com.example.restservice.dao;

import com.example.restservice.Book;
import com.example.restservice.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class BookDAOTest {

    private final Book testBook_1 = new Book("testTitle_1", "testAuthor_1", "testGenre_1");

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void init() {
        entityManager.persist(testBook_1);
        entityManager.flush();
    }

    @AfterEach
    public void clear() {
        entityManager.clear();
    }

    @Test
    void findByTitle() {
        Book findBook = bookRepository.findByTitle(testBook_1.getTitle());
        assertThat(findBook).isEqualTo(testBook_1);
    }

    @Test
    void findByAuthor() {
        Book findBook = bookRepository.findByAuthor(testBook_1.getAuthor()).get(0);
        assertThat(findBook).isEqualTo(testBook_1);
    }

    @Test
    void findByGenre() {
        Book findBook = bookRepository.findByTitle(testBook_1.getTitle());
        assertThat(findBook).isEqualTo(testBook_1);
    }
}