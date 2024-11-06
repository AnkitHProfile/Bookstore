-- Bookstore Inventory Management System Overview
The Bookstore Inventory Management System is a full-stack web application designed to streamline textbook inventory operations. It enables users to browse available books, purchase textbooks, sell back used books, and manage inventory efficiently. The project incorporates modern web development practices and design patterns to ensure scalability, modularity, and maintainability.

-- Features
1. User Authentication:
Secure login and sign-up functionality with session management.
2. Textbook Inventory:
Browse available textbooks with dynamic filtering.
View detailed information about each book, including ISBN, title, authors, edition, and price.
3. Buying and Selling:
Buy books from the inventory, with automatic price depreciation by 10%.
Sell back used books or add new books to the inventory.
4. Session-Specific Actions:
Logout and Back buttons visible based on user login status.
Restricted actions (e.g., buy/sell) for non-logged-in users.

-- Technical Details
1. Backend Framework:
Spring Boot: Used for creating RESTful APIs and handling business logic.
2. Frontend:
Thymeleaf: For rendering dynamic web pages and templates.
3. Database:
PostgreSQL: Used for storing and managing book and user data.
4. Design Patterns:
Factory Pattern: For creating different book objects based on their status (available, sold, resold).
Adapter Pattern: To transform book entities into lightweight resources for frontend consumption.
5. Security:
Session-based authentication and authorization.

-- Prerequisites
1. Java JDK 21 or higher installed.
2. PostgreSQL installed and configured.
3. Maven installed for dependency management.
4. An IDE or text editor (e.g., IntelliJ IDEA, VS Code).

-- Setup Instructions
A. Clone the repository:
git clone https://github.com/your-username/bookstore.git
cd bookstore

-- Configure the database:
1. Open application.properties in the src/main/resources folder.
2. Update the following values with your PostgreSQL credentials:
spring.datasource.url=jdbc:postgresql://localhost:5432/bookstore
spring.datasource.username=your-username
spring.datasource.password=your-password

-- Build and run the application:
mvn clean install
mvn spring-boot:run

-- Access the application:
Navigate to http://localhost:8081 in your browser.

-- API Endpoints
/bookstore (GET) - Displays the welcome page.
/books (GET) - Shows the book inventory page.
/books/api (GET) - Returns all books as JSON.
/books/buy/{id}	(POST) - Buys a book by its ID.
/books/sell/{id}	(POST) - Sells a used book by its ID.
/books/sell	(POST) - Adds a new book to the inventory.
/register	(POST) - Registers a new user.
/login (POST) - Logs in an existing user.
/logout	(GET) - Logs out the current user.

Bookstore/
├── src/
│   ├── main/
│   │   ├── java/org/project/Bookstore/
│   │   │   ├── Book.java
│   │   │   ├── BookAdapter.java
│   │   │   ├── BookController.java
│   │   │   ├── BookFactory.java
│   │   │   ├── BookRepository.java
│   │   │   ├── BookResource.java
│   │   │   ├── BookStatus.java
│   │   │   ├── BookstoreApplication.java
│   │   │   ├── BookstoreController.java
│   │   │   ├── User.java
│   │   │   ├── UserAdapter.java
│   │   │   ├── UserRepository.java
│   │   │   ├── UserResource.java
│   │   ├── resources/
│   │       ├── application.properties
│   │       ├── templates/
│   │           ├── books.html
│   │           ├── welcome.html
├── .gitignore
├── README.md

-- Contributors
Your Name – Ankit Hiremath
GitHub - https://github.com/AnkitHProfile
