package org.project.Bookstore;

public class BookAdapter implements BookResource { // This class is the adapter for Book to match BookResource
    private final Book book; // I made this final because I don’t want it to change after initialization

    public BookAdapter(Book book) { // Constructor where I pass in a Book object
        this.book = book; // Assign the passed Book object to my private book variable
    }

    @Override
    public Long getId() { // This method gets the id of the book
        return book.getId(); // Calls getId() on the book object
    }

    @Override
    public String getIsbn() { // This method gets the ISBN of the book
        return book.getIsbn(); // Calls getIsbn() on the book object
    }

    @Override
    public String getTitle() { // This method gets the title of the book
        return book.getTitle(); // Calls getTitle() on the book object
    }

    @Override
    public String getAuthors() { // This method gets the authors of the book
        return book.getAuthors(); // Calls getAuthors() on the book object
    }

    @Override
    public String getEdition() { // This method gets the edition of the book
        return book.getEdition(); // Calls getEdition() on the book object
    }

    @Override
    public double getPrice() { // This method gets the price of the book
        return book.getPrice(); // Calls getPrice() on the book object
    }

    @Override
    public String getStatus() { // This method gets the status of the book as a string
        return book.getStatus().name(); // Convert the enum status to a String
    }
}