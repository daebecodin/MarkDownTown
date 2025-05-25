
# Remote Procedure Call in Spring Boot

This Spring Boot RPC provides a scalable, secure backend for managing Markdown notes. It offers well-defined HTTP endpoints for creating, reading, updating, and deleting notes with built-in input validation and comprehensive error handling. Notes are persisted in a relational database with transactional integrity and served over JSON-based HTTP calls. The API is designed for extensibility and supports authentication and authorization to safeguard note data.
---
# Currently Working On
- DELETE  for `Folder`, and `Markdown`
---

## Prerequisites

- Java 17+
- Maven or Gradle
- Supabase account with/or a PostgreSQL database
- Postman


## Getting Started

---
## Clone Repository

```bash
git clone https://github.com/daebecodin/MarkDownTown.git
cd MarkDownTown
```

---
## Configure Environment
Create a `.env` (or set OS env vars) with your Supabase credentials:
```bash
JDBC_URL="jdbc:postgresql://db.<region>.supabase.co:5432/<your-db>"
JDBC_USERNAME="postgres"
JDBC_PASSWORD="<your-supabase-password>"
```

---

## Configure Spring Properties
Update `src/main/resources/application.properties` to reference your environment variables
```bash
 spring.application.name=appname

spring.datasource.url=${JDBC_URL}
spring.datasource.username=${JDBC_USERNAME}
spring.datasource.password=${JDBC_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Run the App
``` bash
./gradlew bootRun
```
On startup, the built-in data loader will:
1. Create default users
2. Seed the `markdown` table with example notes


## Call the API endpoints [here](https://duranddyer.postman.co/workspace/CRUD-tuts~607df803-ba5f-41cd-8498-e958a02c3c8a/collection/44811802-a2094595-7899-4060-9237-909f75982096?action=share&creator=44811802&active-environment=44811802-d9bbb7dd-2366-4165-9512-ebbb8ba765b9)
---
## User Api Endpoints

| Method | Path                                 | Description                         |
|--------|--------------------------------------|-------------------------------------|
| GET    | /markdowntown/users                  | List all users(or filter by ?=name) |
| GET    | /markdowntown/users/{id}             | Find a user by id                   |
| POST   | /markdowntown/users/create           | create a user                       |
| PUT    | /markdowntown/users/{id}/update-user | update a user                       |
| DELETE | /markdowntown/users/{id}/delete-user | delete a user                       |


## Folder API Endpoints

| Method | Path                                     | Description           |
|--------|------------------------------------------|-----------------------|
| GET    | /markdowntown/folders                    | List all folder       |
| GET    | /markdowntown/folders/{id}               | Find a folder by id   |
| POST   | /markdowntown/folder/create-new-folder   | create a folder       |
| PUT    | /markdowntown/folders/{id}/update-folder | update a folder by id |


## Markdown API Endpoints

| Method | Path                                         | Description                            |
|--------|----------------------------------------------|----------------------------------------|
| GET    | /markdowntown/markdowns                      | List all markdown(or filter by ?=name) |
| GET    | /markdowntown/markdowns/{id}                 | Find a markdown by id                  |
| POST   | /markdowntown/markdowns/create-new-markdown  | create a markdown                      |
| PUT    | /markdowntown/markdowns/{id}/update-markdown | update a markdown                      |
