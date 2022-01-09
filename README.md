# carScan
Assignment - Add , List , update and Delete the Users

Pre-Requisites : Make sure Installed Below in your Local Computer
  Java 
  Maven
  Git

Step -1 :
Open GIT Bash Locally
   Create New Folder to clone the Project

Step 2 :
Clone the Code 
   git clone git@github.com:NagarjunaRealTime2022/carScan.git

Step 3 : Move to Project Folder 
cd carScan/

Step 4: Build the Project
  mvn clean install 
 
 Step 5: Run the Spring Boot Application
  mvn spring-boot:run
  
( This 5th Step can be done Multiple ways - 
  Example sake used above command from cli)

Wait till the Serer Up

Step 6:
Access Swagger To Test 
   http://localhost:8080/swagger-ui.html#/
   Here Each API of user-controller can be Tested ( Used Swagger to Make Testing easy)
   
UI / PostMan also Can be used.But due to time Limit used Swagger
