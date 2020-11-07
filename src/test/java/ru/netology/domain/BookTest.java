package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book();

    @Test
    void matches() {
        book.setAuthor("Булгаков");
        String text = "Булгаков";

        boolean expected = true;
        boolean actual = book.matches(text);

        assertEquals(expected, actual);
    }

    @Test
    void matchesFalse() {
        book.setAuthor("Булгаков");
        String text = "Колыбельная";

        boolean expected = false;
        boolean actual = book.matches(text);

        assertEquals(expected, actual);
    }
}