# Ecommerce Website Backend

Welcome to the backend section of our Ecommerce Website project! This README provides an overview of the backend architecture, functionalities, and instructions for setting up and running the backend server.

## Table of Contents

- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [Contributing](#contributing)

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

## Contributing

Contributions are welcome! If you'd like to contribute to the project, please follow these steps:

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Create a new Pull Request.

