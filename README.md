# Spring security basic

<p> Step by step to run the project.</p>

> cd ./spring_security_basic

> mvn clean
 
> mvn package
 
> java -jar .\target\spring_security_basic-1.0-SNAPSHOT.jar


<p> If you had docker</p>

> cd ./spring_security_basic

> docker build .

> docker run -p 80:80 {imageId}


<p> Test </p>

>curl --location 'http://localhost/api/authenticate' \
--header 'Content-Type: application/json' \
--data '{
    "username" : "user",
    "password" : "123456"
}'





