
# POS Backend API

## Overview
The POS Backend API is designed to manage various functionalities within a Point of Sale system, covering user authentication, item management, stock updates, category management, and sales processing. This API follows the OpenAPI Specification (OAS 3.0) and provides detailed endpoints for different user roles.

## Purpose
This project was created as a learning experience to understand how to work with Spring Boot, JWT authentication, and Swagger documentation.

## Project Links
- **GitHub Repository**: [Pos-Backend](https://github.com/Sachinthafdo/Pos-Backend)
- **Swagger UI**: `http://localhost:8080/swagger-ui/index.html`

## Security Model
The security model for this API uses JWT authentication to control access based on user roles.

- **Public Access**: No authentication is needed for endpoints like `/auth/**`, `/swagger-ui/**`, and `/v3/**`.
- **Admin-only Access**: Requires an ADMIN role for endpoints starting with `/admin/**`.
- **Manager and Admin Access**: Requires either MANAGER or ADMIN roles for endpoints starting with `/manager/**`.
- **Cashier, Manager, and Admin Access**: Accessible by CASHIER, MANAGER, or ADMIN roles for general requests.

> **Note**: To create an admin user, temporarily permit all requests in `WebSecurityConfig.java`.

## Key Controllers and Endpoints

### 1. Auth Controller
- `POST /auth/login`: Authenticates users and returns a JWT token.
- `POST /admin/users`: Allows admins to create new users.
- `GET /user`: Retrieves the authenticated user's information.
- `GET /admin/allusers`: Lists all users.
- `DELETE /admin/users/{username}`: Deletes a user based on username.

### 2. Item Controller
- `POST /manager/items`: Creates a new item.
- `PUT /manager/items/{id}`: Updates an existing item.
- `DELETE /manager/items/{id}`: Deletes an item by ID.
- `GET /items`: Retrieves all items.
- `GET /items/{id}`: Fetches an item by its ID.

### 3. Stock Controller
- `PUT /manager/stocks`: Updates stock quantity for an item.
- `GET /stocks/{id}`: Retrieves stock details by item ID.

### 4. Category Controller
- `POST /manager/categories`: Creates a new category.
- `PUT /manager/categories/{id}`: Updates an existing category.
- `DELETE /manager/categories/{id}`: Deletes a category.
- `GET /categories`: Retrieves all categories.
- `GET /categories/{id}`: Fetches a category by its ID.

### 5. Sale Controller
- `POST /sale`: Creates a new sale and returns the created entity.
- `GET /sale/{id}`: Retrieves sale details by sale ID.

## Technologies Used
- **Spring Boot**: Backend framework.
- **JWT (JSON Web Token)**: For secure user authentication.
- **Swagger**: For API documentation and testing.

## Setup and Installation
1. Clone the repository from GitHub:
   ```bash
   git clone https://github.com/SACHIBOT/Pos-Backend.git
   ```
2. Navigate to the project directory:
   ```bash
   cd Pos-Backend
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
5. Access the Swagger UI at `http://localhost:8080/swagger-ui/index.html` to explore and test the endpoints.

## License
This project is open-source and available under the [MIT License](https://opensource.org/licenses/MIT). 