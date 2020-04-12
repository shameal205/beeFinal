# beeFinal

For this repo, it is broken up into two halves: UI end and Backend.

UI was developed on angular. 
Backend was developed with Spring boot and MySQL paired together. 


To get started make sure the following is setup:

Assuming mysql is not already installed. Go to https://dev.mysql.com/downloads/mysql/

1) Create a mysql server with your instance set to "localhost:3306", database named "dev_db", and table named "beehive".
2) Make sure your user credentials are both set to "admin"
(Note: look at bee\src\main\resources to verify what the setup should look like)
3) For creating the table here is the sql code to make it.

	CREATE TABLE `beehive` (<br/>
	  `id` varchar(45) NOT NULL,<br/>
	  `speed` int DEFAULT NULL,<br/>
	  `latitude` int DEFAULT NULL,<br/>
	  `longitude` int DEFAULT NULL,<br/>
	  `altitude` int DEFAULT NULL,<br/>
	  `fuel` int DEFAULT NULL,<br/>
	  `damage` int DEFAULT NULL,<br/>
	  `nectar` int DEFAULT NULL,<br/>
	  `honey` int DEFAULT NULL,<br/>
	  PRIMARY KEY (`id`)<br/>
	) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

4) Once completed go to "bees-0.0.1-SNAPSHOT" in the top level of this repo and double click it to start the service.

Here the APIs should be running, to test run "curl -H "Content-Type: application/json" http://localhost:8080/hiveMind/addNewBee -d "{\"id\":\"111\",\"speed\":6}""
(Note: Expect a response of "1")
(Note: This is for windows 10 command, and dont include outer quotes)

To test each API, add the following onto the base "http://localhost:8080/hiveMind"

	/getAllBeeTags(GET) - To retrieve all data in the database.

	/getBeeTag(GET) -  To get a individual bee data.
	
	/addNewBee(POST) - To add a bee to database.
	
  	/updateBee(PUT) - To update an individual bee's data.

	/removeBee(DELETE) - To remove a bee from the database
  
 Here is the list of variables that be inputted:
 {"id","speed","latitude","longitude","altitude","fuel","damage","nectar","honey"}
 
  Here the back-end should be setup
Finally to run the UI follow the instructions below.

1) Go into "home-page"
2) In cmd run "node-modules" using "npm install" 
3) Use "ng serve" following it to start the application.
4) Go to http://localhost:4200/ to see the result.


