# Job_search_Portal_Springboot

This is a Job Search Portal application developed using Spring Boot framework and Java language. The application allows users to create, read, update, and delete job postings. Users can search for jobs based on title and description. The application uses H2 database for data storage.

## Frameworks and Language Used

* Java 11 
* Spring Boot
* Spring Web
* Spring Validation
* SpringBoot Web Tools
* H2 in memory database
* Maven

## Data Flow

The data flow in this system is divided into four main layers: Controller, Service, Repository and Database.

### Controller

The Controller layer handles incoming HTTP requests and responses. It receives the request from the client, validates the input, calls the appropriate service methods, and returns the response to the client.

### Service

The Service layer is responsible for implementing the business logic of the application. It receives the data from the Controller layer, processes it, and interacts with the Repository layer to retrieve or store data.

### Repository
The Repository layer manages the data storage and retrieval. In this application, an in memory H2 database is used to store and manage user data.

### Database Design
This project uses an in-memory data storage approach, using H2 database in Java to store user data.

## Data Structured Used
The project uses Java objects as data structures. The application uses the following data structures:

Job: Represents a job posting.

JobType: Enumerated data structure representing different types of jobs.



## Project Summary

This project is a basic Job search system that allows users to add, retrieve, update, and delete Jobs related data. It uses RESTful web services to handle HTTP requests and responses, and Spring Boot to provide a simple, easy-to-use framework for building the application. Data is stored and managed using the H2 in-memory database, which makes it easy to develop and test the application locally without the need for a separate database server.
