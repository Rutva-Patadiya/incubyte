package com.mycompany;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean borrowBook(String isbn) {
        Optional<Book> bookToBorrow = books.stream()
                .filter(book -> book.getIsbn().equals(isbn) && !book.isBorrowed())
                .findFirst();
        if (bookToBorrow.isPresent()) {
            bookToBorrow.get().setBorrowed(true);
            return true;
        } else {
            throw new IllegalStateException("Book is not available or does not exist.");
        }
    }

    public void returnBook(String isbn) {
        books.stream()
                .filter(book -> book.getIsbn().equals(isbn) && book.isBorrowed())
                .findFirst()
                .ifPresent(book -> book.setBorrowed(false));
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (!book.isBorrowed()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}
