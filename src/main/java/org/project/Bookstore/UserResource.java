package org.project.Bookstore;

public interface UserResource { // This is an interface for representing user details in a simpler way
    Long getId(); // I added this to get the user's ID
    String getDetails(); // This gives a formatted string with the user's details
    String getUsername(); // This returns the user's username
}
