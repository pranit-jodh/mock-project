Dunde Mifflin is a paper company which deals with paper production. API's are implemented according to adding the paper stocks with paper stock Id, paper stock ageging, paper stock color, paper stock size as the attributes.


1) http://localhost:8080/paper/ POST :- Used to post the attributes within the database. The attributes are to be given in the JSON format.

  {
    "paperSize" : "A4",
    "paperAgeingInYears" : 4,
    "paperColor" : "yellow"
}

As the paperStockId is auto generated we don't have to add it in the JSON, the response code is 200 OK and the response body will be getting back from the database.

2) http://localhost:8080/paper/ GET :- For getting all the elements of paper stock in the list format and display it accordingly. If no element is present then it will show 404 status code.

3) http://localhost:8080/paper/1 GET :- For getting a single element of paper stock from the database and if it is not present it will show 404 status along with a user thrown exception.


4) http://localhost:8080/paper/ UPDATE :- This API is used for updating the single json element of paper stock from the database for that the whole json must be passed in the body.

{
    "paperStockId": 2,
    "paperSize": "A4",
    "paperAgeingInYears": 4,
    "paperColor": "yellow"
}

if the reponse status is 200 OK then it is updated successfully and if not then it will thow user exception error.

5) http://localhost:8080/paper/1 DELETE :- For deleting the paper stock we have to send a path variable and the paper stock will be deleted according to the id, if the stock gets deleted then it will show 204 status code.


Along with these API implementation log4j is also implemented to track the logs within the application and spring security where 

Username :- tcs
Password :- tcs

can be used in basic authentication for authorization of the API and accessing it.

Swagger is also implemented where http://localhost:8080/swagger-ui/ URL is used for accessing the API's.

Thank you.
