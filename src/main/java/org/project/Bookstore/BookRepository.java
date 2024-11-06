package org.project.Bookstore;

// This is a repository interface that will allow me to perform CRUD operations on the books table

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> { // Extending JpaRepository gives me all the CRUD operations automatically
    // I don’t need to add any extra code here unless I want custom queries
    // This repository will be used in my BookController to interact with the database
}
