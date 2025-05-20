
# Modern Developer Journal

A simple, markdown-powered note-taker and developer journal built with Spring Boot and Supabase.

---

## Features

- Create, read, update, and delete Markdown notes
- User management with Supabase (PostgreSQL)
- Auto-loader to seed sample data on startup
- Clean, REST-style JSON endpoints

---

## Prerequisites

- Java 17+
- Maven or Gradle
- Supabase account with a PostgreSQL database

---

## Getting Started

### Clone Repository

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

---
## Current API Endpoints

| Method | Path                     | Description                          |
| ------ | ------------------------ | ------------------------------------ |
| GET    | /markdowntown/users      | List all users(or filter by `?=name) |
| GET    | /markdowntown/users/{id} | Find a user by id                    |
| POST   | /markdowntown/users      | create a user                        |
