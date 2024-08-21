# JDBC Basics

## _JDBC Architecture_

Explore the JDBC architecture through the following resources:

- [Introduction to JDBC - GeeksforGeeks](https://www.geeksforgeeks.org/introduction-to-jdbc/)
- [JDBC Architecture - Scaler](https://www.scaler.com/topics/jdbc-architecture/)

## _Service Provider Mechanism_

Learn about Java's Service Provider Mechanism that automatically loads the JDBC drivers:

- [Understanding Java's Service Provider Mechanism - Stack Overflow](https://stackoverflow.com/questions/26551648/understanding-javas-service-provider-mechanism-that-automatically-loads-the-jdb)

## JDBC Connection Process

When you use the `DriverManager.getConnection()` method, the following sequence of events takes place:

1. **Loading JDBC Drivers**
2. **Checking the Connection URL**
3. **Establishing the Connection**

### 1. Loading JDBC Drivers

- Upon initialization, `DriverManager` attempts to load JDBC drivers available on the classpath.
- It looks for `META-INF/services/java.sql.Driver` files, which list the fully qualified class names of JDBC drivers.
- Each listed driver class is loaded, and if it implements the `java.sql.Driver` interface, it registers itself with the `DriverManager` using:

  `DriverManager.registerDriver(this);`

### 2. Checking the Connection URL

- The `DriverManager` iterates over all registered drivers and invokes the `acceptsURL(String url)` method on each one.
- The first driver that returns `true` for this method is selected to establish the connection.

### 3. Establishing the Connection

- Once a suitable driver is found, the `DriverManager` uses the driver’s `connect()` method to create a connection to the database.
- If successful, a `Connection` object is returned, which can be used for further database operations.

## Summary

The `DriverManager` serves as a central registry for JDBC drivers, dynamically loading and registering them. It matches the provided URL with the appropriate driver to establish a connection, facilitating flexible interaction with different types of databases in Java applications.
