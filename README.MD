Step to run application 


1 if you are running with eclipse go to package com.intellect.userservice
 
   run UserServiceApplication main method
 
   run-java application

2. if you want run as jar 
   
   // to run below commonad maven and java install on machine
   a. mvn clean 
   b. mvn install
   c. to run jar 
      java -jar path to jar file  //eg  java -jar D:\workspace\userservice\target\userservice-0.0.1-SNAPSHOT.jar

      
3. to check 

  create 

 url:
POST url 

http://localhost:8080/api/user/create
 //Request  

 {

	"fname": "kunal",
	"lname": "lawand",
	"email": "kunallavand@gmail.com",
	"birthdate": "20-may-2017",
	"isActive": true,
	"pinCode": 414004
  }

//Response

{
	"result": {
		"code": 201,
		"message": "User created successfully",
		"cause": "SUCCESS"
	},
	"userId": "1510995299863"
}

Delete 

GET http://localhost:8080/api/user/delete/1510993943657

//response:

{
    "code": 201,
    "message": "SUCCESS",
    "cause": "SUCCESS"
}


UPDATE

POST URL:http://localhost:8080/api/user/update
  
//request
{

	"id": "1510994169670",
	"birthdate": 1510990443,
	"pinCode": 414005
}


//response

{
    "code": 201,
    "message": "SUCCESS",
    "cause": "SUCCESS"
}# Spring-boot-assignment
