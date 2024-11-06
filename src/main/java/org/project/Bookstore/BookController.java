package org.project.Bookstore;

import org.springframework.beans.factory.annotation.Autowired; // I need this to inject the BookRepository automatically
import org.springframework.stereotype.Controller; // This annotation makes this class a controller in my app
import org.springframework.ui.Model; // I need Model to add data to my HTML pages
import org.springframework.web.bind.annotation.*; // This imports all the Spring annotations for requests

import jakarta.servlet.http.HttpSession; // I use HttpSession to track if a user is logged in
import java.util.List; // List is for storing multiple books in collections
import java.util.stream.Collectors; // Collectors lets me collect items from streams easily

@Controller // This tells Spring that this class is a web controller
@RequestMapping("/books") // Any URL starting with "/books" will be handled by this controller
public class BookController {

    @Autowired // This injects BookRepository so I can use it without creating it manually
    private BookRepository bookRepository;

    // Get all books as BookResources (using adapters)
    @GetMapping("/api") // This maps to GET requests at "/books/api" to get all books
    @ResponseBody // I use this to tell Spring to return data directly instead of a view
    public List<BookResource> getAllBooksAsResources() {
        return bookRepository.findAll() // Get all books from the repository
                .stream() // I convert them to a stream to process them
                .map(BookAdapter::new) // Wrap each book in a BookAdapter
                .collect(Collectors.toList()); // Collect them back into a List
    }

    // Render books in HTML table
    @GetMapping // This maps to GET requests at "/books" to show books in HTML
    public String showBooks(Model model, HttpSession session) {
        List<BookResource> books = bookRepository.findAll() // Fetch all books
                .stream()
                .map(BookAdapter::new) // Wrap them in BookAdapter for consistency
                .collect(Collectors.toList());
        model.addAttribute("books", books); // Add books to the model so I can use them in HTML

        Boolean isLoggedIn = (Boolean) session.getAttribute("loggedIn"); // Check if the user is logged in
        model.addAttribute("isLoggedIn", isLoggedIn != null && isLoggedIn); // Add this info to the model

        return "books"; // Return the books.html page with data from the model
    }

    // Buy a book (change status to 'SOLD')
    @PostMapping("/buy/{id}") // Maps to POST requests at "/books/buy/{id}" to buy a book by id
    @ResponseBody // Return a direct response as a string message
    public String buyBook(@PathVariable Long id) { // id is from the URL path
        Book book = bookRepository.findById(id).orElse(null); // Try to get the book by id
        if (book != null && book.getStatus() == BookStatus.AVAILABLE) { // Check if book exists and is available
            book.setStatus(BookStatus.SOLD); // Set the status to SOLD
            book.setPrice(book.getPrice() * 0.9); // Depreciate price by 10% on sale
            bookRepository.save(book); // Save changes in the repository
            return "Book bought successfully!"; // Return success message
        } else {
            return "Book not available!"; // Return failure if book isn't available
        }
    }

    // Sell a book (existing book, change status to 'RESOLD')
    @PostMapping("/sell/{id}") // Maps to POST requests at "/books/sell/{id}" to sell a book by id
    @ResponseBody // Return a message as a response
    public String sellBook(@PathVariable Long id) { // The book's id from the URL path
        Book book = bookRepository.findById(id).orElse(null); // Try to find the book
        if (book != null && book.getStatus() == BookStatus.SOLD) { // Check if book exists and is sold
            book.setStatus(BookStatus.RESOLD); // Change the status to RESOLD
            book.setPrice(book.getPrice() * 0.9); // Depreciate price by 10% when reselling
            bookRepository.save(book); // Save changes back to the repository
            return "Book sold back successfully!"; // Return success message
        } else {
            return "Book not eligible for selling!"; // Return failure message if not eligible
        }
    }

    // Sell a new book (by ISBN, set status to 'AVAILABLE')
    @PostMapping("/sell") // Maps to POST requests at "/books/sell" to sell a new book
    @ResponseBody // Returns the saved book object as JSON
    public Book sellNewBook(@RequestBody Book book) { // Gets book info from the request body
        // I use BookFactory to create a new available book
        book = BookFactory.createAvailableBook(book.getIsbn(), book.getTitle(), book.getAuthors(), book.getEdition(), book.getPrice());
        return bookRepository.save(book); // Save the new book to the repository
    }
}