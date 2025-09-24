# Chess Online Game

## Project Overview
This is an online chess application built with **Spring Boot** and **MySQL**. The project includes:

- **Class diagram / architecture UML** for the entities.
- <img width="834" height="275" alt="image" src="https://github.com/user-attachments/assets/28ab2901-0bbb-479a-afd6-4347c43e5626" />

- Project created using **Spring Initializer**.
- <img width="1688" height="870" alt="Capture d'écran 2025-09-24 121452" src="https://github.com/user-attachments/assets/14180da7-4aa9-43f5-a376-d0db0c73269a" />



## Authentication Endpoints

### . Register a new user
**POST** http://localhost:8080/api/auth/register  

**Request Body (JSON):**
json :
{
  "username": "ahmed",
  "password": "1234"
}
<img width="1107" height="673" alt="image" src="https://github.com/user-attachments/assets/994b2ad5-92c9-4127-9b35-b7c5938f69b8" />

### . Sign-in
**POST** http://localhost:8080/api/auth/signin

**Request Body (JSON):**
json :
{
  "username": "zoya",
  "password": "1234"
}

<img width="1058" height="783" alt="image" src="https://github.com/user-attachments/assets/44ac3545-b9cc-46c4-a8b1-facc2fc6d07e" />



### . Check User Existance for search

**GET** http://localhost:8080/api/auth/get/ahmed 


<img width="1066" height="824" alt="image" src="https://github.com/user-attachments/assets/1ae44ef3-c6a6-46e1-94c0-bb09b4c85717" />

## Game Endpoints
For Create Game Check invitation Endpoints (Game created automatically when invitation got accepted )
### . Get Specifique Game 
**GET** http://localhost:8080/api/games/1


<img width="1060" height="780" alt="image" src="https://github.com/user-attachments/assets/25d84953-804f-4981-82a2-b1a5e2118e97" />

### . Get all Games
**GET** http://localhost:8080/api/games


<img width="1043" height="765" alt="image" src="https://github.com/user-attachments/assets/be6fd4b0-b52a-4f19-b478-65f1b983a6cc" />

### . Get Game who have waiting status 
**GET** http://localhost:8080/api/games/status/WAITING

<img width="1045" height="774" alt="image" src="https://github.com/user-attachments/assets/90be8ab7-21a1-4841-8818-6f68394133d3" />

### . Change game status
**PUT** http://localhost:8080/api/games/update-status/1?status=IN_PROGRESS

<img width="1044" height="579" alt="image" src="https://github.com/user-attachments/assets/4f02fc70-283d-4f2a-917c-7e11dab99fc3" />

## Move Endpoints

### . Do a Move ( player1 who moves from e2 to e4 in game IN_PROGRESS with player2)
**POST** http://localhost:8080/api/moves/create
<img width="1063" height="613" alt="image" src="https://github.com/user-attachments/assets/512bcbca-37d3-4e78-b0f5-250a8019de80" />

## Invitation Endpoints

### . Send Invitation
**POST** http://localhost:8080/api/invitations/send?sender=ahmed&receiver=escanor
<img width="1038" height="769" alt="image" src="https://github.com/user-attachments/assets/5a240753-1c8a-42be-8f8a-f3f482ded4c9" />

### . Accept Invitation with game created
**PUT** http://localhost:8080/api/invitations/respond/4?status=ACCEPTED
<img width="1038" height="775" alt="image" src="https://github.com/user-attachments/assets/efe0fc2d-d836-4c6d-8083-9f01bcc9cf42" />

### . Show List of pending invitations 
**PUT** http://localhost:8080/api/invitations/respond/4?status=ACCEPTED
<img width="1067" height="778" alt="image" src="https://github.com/user-attachments/assets/e879207c-81ce-4b36-ab3a-65592199d24a" />







