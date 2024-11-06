package org.project.Bookstore;

import jakarta.persistence.*;
import java.text.DecimalFormat;

@Entity // This annotation tells JPA that this class represents a database entity ('books' table in PostgreSQL)
@Table(name = "books") // Specifies that this class is mapped to the "books" table
public class Book { // I made this public so other classes can use it

    @Id // I want Id to be the primary key of this table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // I want automatic generation of id value by the DB
    private Long id; // I want id to be private

    @Column(nullable = false) // I want this column to not allow null values
    private String isbn; // This will store the book's ISBN

    @Column(nullable = false) // Same as above, title shouldn't be null
    private String title; // This stores the title of the book

    @Column(nullable = false) // Again, authors should not be null
    private String authors; // Stores authors of the book

    private String edition; // Edition of the book, can be null so no @Column annotation here

    @Column(nullable = false) // Price should not be null in the database
    private double price; // Price of the book

    @Convert(converter = BookStatus.BookStatusConverter.class) // This converts BookStatus to a string in the DB
    @Column(nullable = false) // Status should not be null
    private BookStatus status = BookStatus.AVAILABLE; // Default status is AVAILABLE

    // Getters and Setters for all the fields

    public Long getId() { // Getter for id
        return id;
    }

    public void setId(Long id) { // Setter for id
        this.id = id;
    }

    public String getIsbn() { // Getter for isbn
        return isbn;
    }

    public void setIsbn(String isbn) { // Setter for isbn
        this.isbn = isbn;
    }

    public String getTitle() { // Getter for title
        return title;
    }

    public void setTitle(String title) { // Setter for title
        this.title = title;
    }

    public String getAuthors() { // Getter for authors
        return authors;
    }

    public void setAuthors(String authors) { // Setter for authors
        this.authors = authors;
    }

    public String getEdition() { // Getter for edition, formats it before returning
        return formatEdition(edition);
    }

    public void setEdition(String edition) { // Setter for edition
        this.edition = edition;
    }

    public double getPrice() { // Getter for price
        return Math.round(price * 100.0) / 100.0; // Rounds price to 2 decimal places
    }

    public void setPrice(double price) { // Setter for price
        this.price = Math.round(price * 100.0) / 100.0; // Again, rounds to 2 decimal places
    }

    public BookStatus getStatus() { // Getter for status
        return status;
    }

    public void setStatus(BookStatus status) { // Setter for status
        this.status = status;
    }

    // This method is to format the edition with ordinal suffix like 1st, 2nd, 3rd, etc.
    private String formatEdition(String edition) {
        if (edition == null || edition.isEmpty()) return edition; // If edition is null or empty, just return it

        int editionNumber; // Variable to hold the numeric part of the edition
        try {
            // This will extract numbers only from the edition string
            editionNumber = Integer.parseInt(edition.replaceAll("[^\\d]", ""));
        } catch (NumberFormatException e) { // Catches exception if parsing fails
            return edition; // If it can't be parsed, return as is
        }

        // Special case for numbers ending in 11, 12, or 13 (they all get "th")
        if (editionNumber % 100 >= 11 && editionNumber % 100 <= 13) {
            return editionNumber + "th";
        }

        // This will handle other numbers based on last digit (1 = st, 2 = nd, 3 = rd, others = th)
        switch (editionNumber % 10) {
            case 1:
                return editionNumber + "st";
            case 2:
                return editionNumber + "nd";
            case 3:
                return editionNumber + "rd";
            default:
                return editionNumber + "th";
        }
    }
}