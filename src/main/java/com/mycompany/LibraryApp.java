package com.mycompany;

public class LibraryApp {
    public static void main(String[] args) {
        // Create a new Library instance
        Library library = new Library();

        // Create and add books to the library
        Book book1 = new Book("1687895", "Java", "R.K. Patel", 2018);
        Book book2 = new Book("6789064", "C++", "R.B. Shah", 2008);

        library.addBook(book1);
        library.addBook(book2);

        // Display available books
        System.out.println("Available books:");
        library.getAvailableBooks().forEach(book ->
                System.out.println(book.getTitle() + " by " + book.getAuthor()));

        // Borrow a book
        System.out.println("\nBorrowing book with ISBN 1687895:");
        try {
            boolean borrowed = library.borrowBook("1687895"); // Use correct ISBN
            System.out.println("Borrowed: " + borrowed);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        // Display available books after borrowing
        System.out.println("\nAvailable books after borrowing:");
        library.getAvailableBooks().forEach(book ->
                System.out.println(book.getTitle() + " by " + book.getAuthor()));

        // Return the book
        System.out.println("\nReturning book with ISBN 1687895:");
        library.returnBook("1687895"); // Use correct ISBN

        // Display available books after returning
        System.out.println("\nAvailable books after returning:");
        library.getAvailableBooks().forEach(book ->
                System.out.println(book.getTitle() + " by " + book.getAuthor()));
    }
}
