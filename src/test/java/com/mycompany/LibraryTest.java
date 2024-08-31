package com.mycompany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("1687895", "Java", "r.k patel", 2018);
        library.addBook(book);
        assertTrue(library.getAvailableBooks().contains(book));
    }

    @Test
    public void testBorrowBook() {
        Book book = new Book("1687895", "Java", "Joshua Bloch", 2018);
        library.addBook(book);
        assertTrue(library.borrowBook("1687895"));
        assertFalse(library.getAvailableBooks().contains(book));
    }

    @Test
    public void testBorrowBookNotAvailable() {
        assertThrows(IllegalStateException.class, () -> {
            library.borrowBook("99999");
        });
    }

    @Test
    public void testReturnBook() {
        Book book = new Book("1687895", "Java", "r.k patel", 2018);
        library.addBook(book);
        library.borrowBook("1687895");
        library.returnBook("1687895");
        assertTrue(library.getAvailableBooks().contains(book));
    }

    @Test
    public void testViewAvailableBooks() {
        Book book1 = new Book("1687895", "Java", "r.k patel", 2018);
        Book book2 = new Book("6789064", "c++", "R b shah", 2008);
        library.addBook(book1);
        library.addBook(book2);
        List<Book> availableBooks = library.getAvailableBooks();
        assertTrue(availableBooks.contains(book1));
        assertTrue(availableBooks.contains(book2));
    }
}