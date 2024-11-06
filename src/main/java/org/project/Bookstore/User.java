// User.java
package org.project.Bookstore;

import jakarta.persistence.*;

@Entity // This tells JPA that this class represents an entity (table) in the database
@Table(name = "users") // I want this class to be mapped to a table named "users"
public class User { // Class representing each user in the bookstore system

    @Id // Setting the id field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Letting the database automatically generate a unique ID for each user
    private Long id; // This will store each user's unique ID

    private String firstName; // User's first name
    private String lastName; // User's last name
    private String username; // Username for login, has to be unique
    private String password; // User's password (stored in plain text here)

    // Getters and Setters - used to access and update the private fields

    public Long getId() { return id; } // Getting the user's ID
    public void setId(Long id) { this.id = id; } // Setting the user's ID

    public String getFirstName() { return firstName; } // Getting the user's first name
    public void setFirstName(String firstName) { this.firstName = firstName; } // Setting the user's first name

    public String getLastName() { return lastName; } // Getting the user's last name
    public void setLastName(String lastName) { this.lastName = lastName; } // Setting the user's last name

    public String getUsername() { return username; } // Getting the user's username
    public void setUsername(String username) { this.username = username; } // Setting the user's username

    public String getPassword() { return password; } // Getting the user's password
    public void setPassword(String password) { this.password = password; } // Setting the user's password
}
