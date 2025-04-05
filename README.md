
# Spring Boot Real-Time Messaging API

A robust real-time messaging backend application built with Spring Boot that features JWT authentication, WebSocket communication, and secure messaging capabilities.

## Features

- **User Authentication**: Secure login system with JWT token-based authentication
- **Real-time Messaging**: WebSocket implementation for instant message delivery
- **RESTful API**: Comprehensive endpoints for user and message management
- **Role-based Access Control**: Different permission levels for users and admins

## Technology Stack

- Java 17
- Spring Boot 3.x
- Spring Security with JWT (RSA keys)
- Spring WebSocket
- MySQL Database
- Maven

## API Endpoints

### Authentication
- `POST /auth/token` - Obtain JWT token
- `POST /auth/register` - Register new user
- `GET /auth/isToken` - Verify token validity
- `GET /auth/getUsers` - Get current user information
- `GET /auth/tokenIs` - Logout

### Messages
- `GET /api/messages` - Get all messages
- WebSocket endpoint: `/ws`
- Message sending: `/app/chat.send`
- Message subscription: `/topic/public`

## Database Schema

The application uses the following database tables:
- `users` - User credentials and information
- `authorities` - Available user roles
- `users_authorities` - Many-to-many mapping between users and roles
- `messages` - Message content and sender information

## Setup & Installation

1. Clone the repository
2. Configure MySQL database in `application.properties`
3. Generate RSA keys for JWT and place in `src/main/resources/certs/`
4. Build the project:
   ```bash
   mvn clean install


# Run the application:
mvn spring-boot:run

## Security
The application implements security using:
- JWT authentication with RSA public/private key pair
- Role-based authorization
- Secure WebSocket connections

## Frontend Application
This backend is designed to work with a dedicated frontend application. The frontend code is available at: https://github.com/eraldtorra/messageAngular

## API Documentation
API documentation is available through Swagger UI:
- /swagger-ui.html - Swagger UI interface
- /api-docs - OpenAPI specification

## Monitoring
Spring Boot Actuator endpoints are enabled:
- /actuator/health - System health information
- /actuator/metrics - Application metrics
- /actuator/info - Application information