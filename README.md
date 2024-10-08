# Incident Management App

This is a simple incident management application built with Spring Boot. It provides basic functionality for creating, modifying, deleting, and listing incidents. The application uses an in-memory database (H2) for data storage.

## Features

- **Create Incident**: You can create a new incident by providing a unique name, description, and other details.
- **Modify Incident**: Update the description and status of an existing incident.
- **Delete Incident**: Remove an incident by specifying its ID.
- **List Incidents**: Retrieve a list of all active incidents.

## Technology Stack

- **Java 17**: The programming language used for development.
- **Spring Boot**: A powerful framework for building enterprise applications.
- **H2 Database**: An in-memory database for quick development and testing.

## Getting Started

### Prerequisites

- Java 17 or higher.
- Maven.
- Docker (optional for containerized deployment).

### Running the Application
## Use terminal to run the project
1. Clone the repository:
    ```bash
    git clone git@github.com:yzwuestc/earth.git
    ```

2. Build the project using Maven:
    ```bash
    cd earth
    mvn clean install
    ```
3. Run the application:
    ```bash
    java -jar target/earth.jar
    ```
## Use IntelliJ IDEA to run the project
1. Import the project from this repository
   ![image](image/img_1.png)
2. Click the run button to run this project
   ![image](image/img.png)

The application will start on port 8080 by default. You can access the API endpoints using a tool like Postman or curl.

## API Endpoints

### Create Incident
```sh
curl -X POST http://localhost:8080/incidents/create \
     -H "Content-Type: application/json" \
     -d '{"name": "New Incident", "description": "Description for new incident"}'
```
### Delete Incident
```sh
curl -X POST http://localhost:8080/incidents/delete/1
```
### Update Incident
```sh
curl -X POST http://localhost:8080/incidents/update \
     -H "Content-Type: application/json" \
     -d '{"id":1, "name":"Incident 1","description": "Updated description", "status": "CLOSED"}'
```
### List Incidents
```sh
curl http://localhost:8080/incidents/list

as this is a get request, you can also use the browser to access this endpoint
```

# Docker Deployment (Optional)
## Build Docker Image
```sh
docker build -t earth .
```
## Run the Docker container:
```sh
docker run -p 8080:8080 earth
```

# Unit Testing
The project includes unit tests for the main components of the application. To run the tests, use the following command:
```sh
mvn test
```
or use IntelliJ IDEA to run the test
The tests cover various scenarios such as creating, modifying, and deleting incidents, as well as handling errors.