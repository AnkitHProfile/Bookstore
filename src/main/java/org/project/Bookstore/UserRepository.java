// UserRepository.java
package org.project.Bookstore;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> { // This interface extends JpaRepository to handle database operations for User
    Optional<User> findByUsername(String username); // I added this method to find a user by their username
}
