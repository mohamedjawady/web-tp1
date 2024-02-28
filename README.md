# Ecommerce Website Backend

Welcome to the backend section of our Ecommerce Website project! This README provides an overview of the backend architecture, functionalities, and instructions for setting up and running the backend server.

## Table of Contents

- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [Interacting with the API](#interacting-with-the-api)

## Overview

Our Ecommerce Website backend is responsible for handling various functionalities related to managing users, products, and other ecommerce operations. It provides RESTful APIs for frontend clients to interact with the server.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Spring Web
- MySQL
- Maven for dependency management

## Project Structure

The backend project is structured as follows:

- `src/main/java/com/isi/webtp1`: Root package for Java source files.
    - `controller`: Contains REST controllers for handling HTTP requests.
    - `dto`: Data Transfer Objects for transferring data between layers.
    - `entity`: JPA entities representing database tables.
    - `repository`: Spring Data JPA repositories for database operations.
    - `service`: Service layer for business logic.
- `src/main/resources`: Configuration files, such as `application.properties`.

## Getting Started

To set up and run the backend server locally:

1. Clone this repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Configure your database connection in `src/main/resources/application.properties`.
4. Run the application as a Spring Boot application.

## Endpoints

The backend provides the following endpoints:

- `/api/products`: Endpoints for managing products.
- `/api/users`: Endpoints for managing users.

For detailed information on each endpoint, refer to the respective controller classes.

## Interacting with the API

You can interact with the API using cURL commands. Assuming the application is running on port 9999:

### Example cURL Commands:

```bash
# Create a new product
curl -X POST -H "Content-Type: application/json" -d '{"name":"Product Name", "description":"Product Description", "price":10.99, "quantity":100}' http://localhost:9999/api/products

# Retrieve all products
curl http://localhost:9999/api/products

# Retrieve a specific product by ID
curl http://localhost:9999/api/products/{id}

# Get products by price range
curl http://localhost:9999/api/products/search?min=0&max=9999999

# Update a product by ID
curl -X PUT -H "Content-Type: application/json" -d '{"name":"Updated Product Name", "description":"Updated Product Description", "price":15.99, "quantity":50}' http://localhost:9999/api/products/{id}

# Delete a product by ID
curl -X DELETE http://localhost:9999/api/products/{id}

# Get all users
curl http://localhost:9999/api/users

# Get public user info
curl http://localhost:9999/api/users/public

# Add a user
curl -X POST -H "Content-Type: application/json" -d '{"username":"hbib", "password":"hbibpassword", "firstName":"mohamed habib", "lastName":"jaouadi"}' http://localhost:9999/api/users

# Add products to user
curl -X POST -H "Content-Type: application/json" -d '[{"name":"laptop","description":"some enriched text here","quantity":1,"price":9999,"soldStatus":false,"listedStatus":false,"thumbnailImage":"https://images.unsplash.com/photo-1496181133206-80ce9b88a853?q=80&w=1771&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D","imageURLs":["#","#","#"]}]' http://localhost:9999/api/users/1/products

# Get user by ID
curl http://localhost:9999/api/users/{id}

# Update user by ID
curl -X PUT -H "Content-Type: application/json" -d '{"username":"hbib", "password":"hbibpassword3", "firstName":"mohamed habib", "lastName":"jaouadi"}' http://localhost:9999/api/users/{id}

# Delete user by ID
curl -X DELETE http://localhost:9999/api/users/{id}
