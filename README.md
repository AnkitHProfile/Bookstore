# 📚 Bookstore Inventory Management System

The **Bookstore Inventory Management System** is a full-stack web application built using **Spring Boot**, **PostgreSQL**, and **Thymeleaf**. It enables users to browse, purchase, and sell textbooks, with a focus on clean architecture and maintainable code through design patterns like **Factory** and **Adapter**.

---

## 🚀 Features

- **User Authentication**: Secure login and sign-up with session handling.
- **Inventory Management**: Browse textbooks with filters and detailed info (ISBN, author, edition, price).
- **Buy & Sell Operations**:
  - Buy books with automatic 10% price depreciation.
  - Sell used books or add new books to inventory.
- **Session Awareness**: Logout/Back buttons shown only when logged in; restricted access for guests.

---

## ⚙️ Tech Stack

| Layer     | Technology                        |
|-----------|-----------------------------------|
| Backend   | Spring Boot (RESTful API)         |
| Frontend  | Thymeleaf (HTML templating)       |
| Database  | PostgreSQL                        |
| Patterns  | Factory & Adapter Design Patterns |
| Security  | Session-based Authentication      |

---

## 🛠️ Prerequisites

- Java JDK 21 or higher
- PostgreSQL installed and running
- Maven installed
- IDE like IntelliJ IDEA or VS Code

---

## 📦 Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/your-username/bookstore.git
cd bookstore
```

### 2. Configure the database

Edit `src/main/resources/application.properties` and update the values with your PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bookstore
spring.datasource.username=your-username
spring.datasource.password=your-password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
server.port=8081
```

> 📌 Replace `your-username` and `your-password` with your actual PostgreSQL credentials.

### 3. Build and run the application

```bash
mvn clean install
mvn spring-boot:run
```

### 4. Access the app

Open your browser and navigate to:  
[http://localhost:8081](http://localhost:8081)

---

## 📡 API Endpoints

| Endpoint                  | Method | Description                        |
|---------------------------|--------|------------------------------------|
| `/bookstore`              | GET    | Displays the welcome page          |
| `/books`                  | GET    | Shows book inventory               |
| `/books/api`              | GET    | Returns all books as JSON          |
| `/books/buy/{id}`         | POST   | Buys a book by ID                  |
| `/books/sell/{id}`        | POST   | Sells a used book by ID            |
| `/books/sell`             | POST   | Adds a new book to the inventory   |
| `/register`               | POST   | Registers a new user               |
| `/login`                  | POST   | Logs in an existing user           |
| `/logout`                 | GET    | Logs out the current user          |

---

## 📁 Project Structure

```
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
│   ├── resources/
│   │   ├── application.properties
│   │   ├── templates/
│   │   │   ├── books.html
│   │   │   ├── welcome.html
├── .gitignore
├── README.md
```

---

## 👨‍💻 Contributor

**Ankit Hiremath**  
GitHub: [AnkitHProfile](https://github.com/AnkitHProfile)

---

## 📄 License

This project is licensed under the MIT License. See the `LICENSE` file for details.
