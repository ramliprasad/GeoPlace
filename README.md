#GEOSpace App

The app facilitates the input of candidate information and all the necessary CRUD operation 
can be performed using this app.

##Endpoints

####[Add](http://localhost:8080/entries) all candidate details **METHOD=POST** `http://localhost:8080/entries`. Use data.json file from resources directory for initial input of data 
####[Get](http://localhost:8080/entries) all Candidate details **METHOD=GET** `http://localhost:8080/entries`
####[Update](http://localhost:8080/entries/1) Candidate detail **METHOD=PUT** `http://localhost:8080/entries/1`. Please provide a valid JSON from data.json file
####[Delete](http://localhost:8080/entries/1) Candidate detail **METHOD=DELETE** `http://localhost:8080/entries/1`

>!!Happy Testing!!