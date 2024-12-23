## README

This project implements the Blackboard Pattern using Java 17 Flow interfaces and Spring Boot.

### How it works

When the server is started, the blackboard (SubmissionPublisher) is initialized and subscribes a processor (Flow.Subscriber)<br>
When the api /api/bbp is triggered, one or more blackboard objects are placed on the blakboard<br>
The processor, upon receiving the blackboard objects, spawns knowledgesource worker threads that can handle the blackboard objects.<br>


A pending item in this project is - knowledge sources placing unfinished blackboard objects back on the blackboard for further processing.  

### Usage

To run the application locally, run '.\gradlew bootRun'

The Swagger UI can be accessed using http://localhost:8080/swagger-ui/index.html
