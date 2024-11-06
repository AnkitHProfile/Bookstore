// BookstoreController.java
package org.project.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;

@Controller // Marks this class as a Spring MVC controller
public class BookstoreController { // Controller class for handling user-related actions like login and registration

    @Autowired // Tells Spring to inject the UserRepository bean here automatically
    private UserRepository userRepository;

    @GetMapping("/bookstore") // Mapping for the main welcome page of the bookstore
    public String welcomePage() {
        return "welcome"; // Refers to the welcome.html template to show the welcome page
    }

    @PostMapping("/register") // Mapping to handle user registration requests
    @ResponseBody // Sends the return value directly as the HTTP response body
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // @RequestBody tells Spring to bind the incoming JSON data to a User object
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        // Checking if the username already exists in the database

        if (existingUser.isPresent()) {
            // If user already exists, we return a response indicating the failure to register
            return ResponseEntity.ok().body(Map.of("success", false, "message", "This account already exists. Please Login"));
        }

        userRepository.save(user); // Save the new user (password stored in plain text as per request)
        return ResponseEntity.ok().body(Map.of("success", true, "message", "User registered successfully!"));
        // Sends a success message back to the client
    }

    @PostMapping("/login") // Mapping to handle login requests
    @ResponseBody // Returns the login result directly in the response body
    public ResponseEntity<?> loginUser(@RequestBody User loginUser, HttpSession session) {
        // loginUser holds the login data from the client, and HttpSession manages user session
        Optional<User> user = userRepository.findByUsername(loginUser.getUsername());
        // Finds user by username

        if (user.isPresent()) {
            // If the user exists in the database, check if the password matches
            if (user.get().getPassword().equals(loginUser.getPassword())) {
                session.setAttribute("loggedIn", true); // Set session attribute on successful login
                return ResponseEntity.ok(Map.of("success", true, "message", "Login successful"));
            } else {
                return ResponseEntity.ok(Map.of("success", false, "message", "The password is incorrect"));
                // Password doesn't match, send an error message
            }
        } else {
            return ResponseEntity.ok(Map.of("success", false, "message", "No such account exists"));
            // Username not found, send another error message
        }
    }

    @GetMapping("/logout") // Mapping to handle logout requests
    public String logoutUser(HttpSession session) {
        session.invalidate(); // Clear the session to log out the user
        return "redirect:/bookstore"; // Redirect the user back to the welcome page after logout
    }
}