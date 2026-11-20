# Employee Management - Module 10

Spring Boot reporting and analytics mini-project with Spring Data JPA `@Query`, REST endpoints, and a Thymeleaf statistics page.

## Features

- Reports the total employee count.
- Groups employees by department using a repository `@Query` aggregate.
- Exposes the reports as JSON and renders them on `/employees/statistics`.
- Includes five sample employees in `data.sql` so the reports show sample results on startup.

## Run

```bash
mvn spring-boot:run
```

Open the web report at [http://localhost:8080/employees/statistics](http://localhost:8080/employees/statistics).

## REST API

- `GET /api/statistics/employee-count` — `{"totalEmployees":5}`
- `GET /api/statistics/employees-by-department` — array of department names and employee counts

The sample data is loaded into an in-memory H2 database and is recreated each time the app starts.
