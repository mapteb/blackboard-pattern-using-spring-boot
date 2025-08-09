## README

This project implements the [Blackboard Design Pattern](https://en.wikipedia.org/wiki/Blackboard_(design_pattern)) using Spring Boot. A fictitious autonav scenario is considered in this POC project. The BlackBoard receives data from multiple vehicle sensors and is required to react based on the actions performed by the KnowledgeSources (AI Agents) on the BlackBoardObjects.


### Blackboard Components

The Blackboard design pattern involves three components - 
1. BlackBoard - holds a list of BlackBoardObjects, publishes events when BlackBoardObjects are added
2. BBController - holds a list of KnowledgeSources, listens to the events published by the blackboard, when a BlackBoardObject is received assigns it to an eligible KnowledgeSource and launches it as a worker thread.
3. KnowledgeSource - (could be an AI Agent) acts on the assigned BlackBoardObject, when completed updates the BlackBoard with the completed object


### How it works

The following steps are involved:

1. When the application is started, a set of KnowledgeSources are added to the BBController.<br>
2. When the api /api/bbp is triggered, one or more BlackBoardObjects are placed on the blakboard. In this POC the component that places blackboard objects is a RestController. This could be a Spring Reactive webclient ingesting streaming data from an external API.<br>
3. The BBController, upon receiving the blackboard objects, spawns KnowledgeSource worker threads that can handle the BlackBoardObjects.<br>
4. The KnowledgeSources update the BlackBoard with their completed BlackBoardObjects
5. The final step of reacting to the analyzed data is not considered in this POC.


### Use Cases

Some use cases for this application could be

1. Autonavigation where data is streaming from multiple devices and knowledgesources handle each of the sensor data.
2. During election time a TV station can handle data streaming in from multiple states and present the realtime results for each state in a separate graphics panel. The knowledge sources could be specialists in analyzing voting results data from a particular region.


### Usage

To run the application locally, run '.\gradlew bootRun'

The Swagger UI can be accessed using http://localhost:8080/swagger-ui/index.html and the POST api /api/bbp can be accessed to trigger the blackboard process. The following application logs can be observed:

&gt;&gt; Configuring AutoNavBBController with KnowledgeSources<br>
&gt;&gt; Adding BlackBoardObjects to the Blackboard<br>
&gt;&gt; Received BlackBoardObject: DeltaSpeedData<br>
&gt;&gt; Launching KnowledgeSource as a worker thread: DeltaSpeedData<br>
&gt;&gt; DeltaSpeedDataKS updating the BlackBoard DeltaSpeedData analysis completed<br>
&gt;&gt; Received BlackBoardObject: FrontVehicleData<br>
&gt;&gt; Launching KnowledgeSource as a worker thread: FrontVehicleData<br>
&gt;&gt; FrontVehicleDataKS updating the BlackBoard FrontVehicleData analysis completed<br>


### Docker build and run

docker compose up --build


### TBD


Add an AutoNavVehicleController that listens to the list of completed BlackBoardObjects, when received analyzes and executes a vehicle action (like breaking, speeding, etc.)

