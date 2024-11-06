package org.project.Bookstore;

// I created this interface to define what information each book should provide

public interface BookResource { // This interface acts like a blueprint for books in the project
    Long getId(); // Every book has to provide an ID
    String getIsbn(); // Every book has to provide an ISBN
    String getTitle(); // Every book has to provide a title
    String getAuthors(); // Every book has to provide its authors
    String getEdition(); // Every book has to have an edition
    double getPrice(); // Every book has to provide a price
    String getStatus(); // Every book has to have a status (like AVAILABLE, SOLD, etc.)
}