# Mini Project 1 -- API Project (Alternative API Project)

## Description
The Agile-Application-Api takes post requests (with JSON body) and saves correctly-formatted data to a Postgres database that is run locally. This API has been tested and it automatically creates a table under a database named "testdb".
This API is written in Kotlin and is a Spring-Boot application.

## Steps to Running the API
### Before we begin:
You need the following applications to be running:
* PostgreSQL (9.5.~) -- Make sure you put postgres as username and password for first set-up. If you change this, you will have to change it in the API.
* Postman
* IDE that supports Spring-Boot applications (I am using IntelliJ IDEA Ultimate, which can be downloaded [here](https://www.jetbrains.com/idea/))
* JDK 1.8 -- Link [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

### Once you have everything, here are the steps:
#### Step 1: You can choose to configure your Spring-Boot Application Configurations (though this isn't required). 
  * Open IDEA and open the project. On the right hand side, you will see Maven Projects.
  * Double Click agileapplicationapi > Lifecycle > clean
  * Double Click agileapplicationapi > Lifecycle > install
  ** If you see an option that pops up for Enabling Auto-import, DO THAT! **
  * Right Click agileapplicationapi > Plugins > spring-boot > spring-boot:run and choose the **second option**

#### Step 2: After Step 1, you should see the console print something like this:
> 2018-09-11 11:00:19.965  INFO 14496 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
  
> 2018-09-11 11:00:19.967  INFO 14496 --- [           main] c.b.a.AgileapplicationapiApplicationKt   : Started AgileapplicationapiApplicationKt in 5.971 seconds (JVM running for 15.243)
  
When you see this, head over to Postman and create a POST request to http://localhost:8080/save.
An example is provided below:
![Postman](https://github.com/ayshimz/EC601/blob/master/images/miniproject1/postman_POSTreqtoAPI.JPG)

*You must make sure that the JSON object you send is formatted in the way above. If you don't, it may throw an error and give a 400 request*
  
#### Step 3: After you complete Step 2, you should be able to see the change in your postgres database.
An example is provided below:
![Postgres](https://github.com/ayshimz/EC601/blob/master/images/miniproject1/postgres_database.JPG)
  
#### Step 4: If you do not want to go through your Postgres, you can also access the data in your database through your webbrowser, by going to http://localhost:8080/findall
An example is provided below:
![FindAll](https://github.com/ayshimz/EC601/blob/master/images/miniproject1/findAll_demo.JPG)

#### Step 5: Finally, if you want to search through the database for a particular user Id, you can do so by hitting the endpoint: http://localhost:8080/findbyUserId/{userId} <-- This is case-sensitive!
An example is provided below:
![FindbyUserId](https://github.com/ayshimz/EC601/blob/master/images/miniproject1/findbyUserId_demo.JPG)
  
