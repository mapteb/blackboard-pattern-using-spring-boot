## README

This project implements the Blackboard Pattern using Java 17 Flow interfaces and Spring Boot.

### How it works

When the server is started, the blackboard (SubmissionPublisher) is initialized and subscribes a processor (Flow.Subscriber) to the publisher.<br>
When the api /api/bbp is triggered, one or more blackboard objects are placed on the blakboard. In this POC the component that places blackboard objects is a RestController. This could be a Spring Reactive webclient ingesting streaming data from an external API.<br>
The processor, upon receiving the blackboard objects, spawns knowledgesource worker threads that can handle the blackboard objects.<br>
The above steps should result in a streaming data handler in a scalable way.

A pending item in this project is - knowledge sources placing unfinished blackboard objects back on the blackboard for further processing.

### Use Cases

Some use cases for this application could be

1. Autonavigation where data is streaming from multiple devices and each knowledgesource can be specialized to handle data from each device.
2. During election time a TV station can handle data streaming in from multiple states and present the realtime results for each state in a separate graphics panel.
3. ... and so on.

### Usage

To run the application locally, run '.\gradlew bootRun'

The Swagger UI can be accessed using http://localhost:8080/swagger-ui/index.html
