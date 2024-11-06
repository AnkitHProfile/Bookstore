package org.project.Bookstore;

public class UserAdapter implements UserResource { // Adapter class to adapt the User object to the UserResource interface
    private final User user; // The User object I'm adapting

    public UserAdapter(User user) { // Constructor to initialize with a User object
        this.user = user; // Set the user field to the provided User instance
    }

    @Override
    public Long getId() { // Getting the ID from the User object
        return user.getId(); // Return the user's ID
    }

    @Override
    public String getDetails() { // Constructing a string with user details
        return "User: " + user.getFirstName() + " " + user.getLastName(); // Concatenate first and last name for a full name
    }

    @Override
    public String getUsername() { // Getting the username from the User object
        return user.getUsername(); // Return the user's username
    }
}
