# Login System with HikariCP

## Project Overview

This project is a simple Java application designed for user registration and login. It demonstrates the use of HikariCP, a high-performance JDBC connection pool, to manage database connections efficiently.

## Purpose

The main purpose of this project is to provide a basic user authentication system. Users can:
- **Register**: Create a new account with a username and password.
- **Login**: Authenticate with existing credentials.

The application connects to a MySQL database to store and retrieve user information.

## HikariCP

This project utilizes **HikariCP** for managing database connections. HikariCP is a fast and reliable JDBC connection pool that offers several benefits:
- **Performance**: Provides high-performance connection pooling to handle database interactions efficiently.
- **Caching**: Caches prepared statements to reduce overhead and improve execution speed.
- **Configuration**: Allows fine-tuning of various properties to optimize connection management.

In the `Koneksi` class, HikariCP is configured with properties such as:
- **`cachePrepStmts`**: Enables caching of prepared statements.
- **`prepStmtCacheSize`**: Specifies the number of prepared statements to cache.
- **`prepStmtCacheSqlLimit`**: Sets the maximum size of SQL statements to cache.

## Key Files

- **`Koneksi.java`**: Configures and manages the HikariCP connection pool.
- **`DbAccess.java`**: Handles database operations, including saving and checking user credentials.
- **`LoginService.java`**: Provides business logic for user registration and login.
- **`LoginApp.java`**: The entry point of the application, providing a user interface for interaction.

## How to Use

1. **Run the Application**: Launch `LoginApp.java` from your IDE or command line.
2. **Register**: Follow the prompts to create a new account.
3. **Login**: Use your registered credentials to log in.

## Conclusion

This project demonstrates basic user authentication using Java and MySQL, with efficient connection management provided by HikariCP. It serves as a foundational example for integrating JDBC with connection pooling in a Java application.

