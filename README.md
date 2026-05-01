# User Order System with Caching (Spring Boot + Hibernate)

## Project Description

This project demonstrates a simple User and Order system using Spring Boot and Hibernate (JPA). It implements a one-to-many relationship where one user can have multiple orders. It also includes a basic caching mechanism using a HashMap to reduce database calls.

The main objective of this project is to understand:

* Entity relationships (One-to-Many)
* Hibernate ORM mapping
* Auto-generated IDs
* Simple caching concept

---

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA (Hibernate)
* MySQL
* Maven

---

##  Project Structure

* entity → contains User and Order classes
* repository → contains JPA repository
* service → contains business logic and caching
* main class → runs the application

---

## Relationship

* One User → Many Orders (1:N relationship)
* Implemented using `@OneToMany` annotation

---

## Configuration

Update the database details in `application.properties`:

spring.datasource.url=jdbc:mysql://localhost:3306/testdb
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

---

## How to Run

1. Create database in MySQL:
   CREATE DATABASE testdb;

2. Open project in Eclipse / IntelliJ

3. Update database username and password

4. Run the main class:
   UserOrderCachingApplication.java

---

## Functionality

* When `getUser(id)` is called:

  * First time → Data is fetched from database and stored in cache
  * Next time → Data is fetched from cache instead of database

---

## Sample Output

Fetching from Database...
User: Meghana
Order: Mobile
Order: Laptop

Fetching from Cache...
User: Meghana
Order: Mobile
Order: Laptop

---

## Important Notes

* Table name "orders" is used instead of "order" because "order" is a reserved keyword in MySQL
* IDs are auto-generated using `@GeneratedValue`
* Cache is implemented using HashMap

---

## Conclusion

This project helps in understanding how Spring Boot works with Hibernate, how relationships are mapped, and how caching can improve performance by reducing database access.

---
