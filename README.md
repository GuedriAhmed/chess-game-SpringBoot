# Chess Online Game

## Project Overview
This is an online chess application built with **Spring Boot** and **MySQL**. The project includes:

- **Class diagram / architecture UML** for the entities.
- Project created using **Spring Initializer**.
- **Authentication system**: simple account creation and login.
- **Online player invitation system**.
- **Automatic game creation** if the invitation is accepted.
- **Minimal persistence**: saving each move in the database (game history).

---

## Authentication Endpoints

### 1. Register a new user
**POST** http://localhost:8080/api/auth/register  

**Request Body (JSON):**
json :
{
  "username": "ahmed",
  "password": "1234"
}
