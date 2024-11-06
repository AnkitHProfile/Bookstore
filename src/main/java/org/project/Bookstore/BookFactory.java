package org.project.Bookstore;

public class BookFactory { // This is my factory class to create books with specific statuses

    // Method to create an available book
    public static Book createAvailableBook(String isbn, String title, String authors, String edition, double price) {
        Book book = new Book(); // Create a new Book object
        book.setIsbn(isbn); // Set ISBN of the book
        book.setTitle(title); // Set the title of the book
        book.setAuthors(authors); // Set the authors of the book
        book.setEdition(edition); // Set the edition of the book
        book.setPrice(price); // Set the price of the book
        book.setStatus(BookStatus.AVAILABLE); // Set status to AVAILABLE
        return book; // Return the new book
    }

    // Method to create a sold book
    public static Book createSoldBook(String isbn, String title, String authors, String edition, double price) {
        Book book = createAvailableBook(isbn, title, authors, edition, price); // Start with an available book
        book.setStatus(BookStatus.SOLD); // Change the status to SOLD
        book.setPrice(price * 0.9); // Depreciate price by 10% if sold
        return book; // Return the sold book
    }

    // Method to create a resold book
    public static Book createResoldBook(String isbn, String title, String authors, String edition, double price) {
        Book book = createAvailableBook(isbn, title, authors, edition, price); // Start with an available book
        book.setStatus(BookStatus.RESOLD); // Change the status to RESOLD
        book.setPrice(price * 0.8); // Depreciate price further if resold
        return book; // Return the resold book
    }
}