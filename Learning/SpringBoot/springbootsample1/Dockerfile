##  command to run in docker : ./mvnw package && java -jar target/springBootSample1-0.0.1-SNAPSHOT.jar

## To run without containerize

##FROM openjdk:8-jdk-alpine
##VOLUME /tmp
##ARG DEPENDENCY=target/dependency
##COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
##COPY ${DEPENDENCY}/META-INF /app/META-INF
##COPY ${DEPENDENCY}/BOOT-INF/classes /app
##ENTRYPOINT ["java","-cp","app:app/lib/*","hello.Application"]


## To run with containerize


##FROM openjdk:8-jdk-alpine
##VOLUME /tmp
##ARG JAR_FILE
##COPY ${JAR_FILE} app.jar
##ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

## To run with containerize with complete separation between dependencies and artifact
## command to create image : ./mvnw install dockerfile:build
## command to run image to docker : docker run -p 8081:8081 -t tridentamit/springbootsample1:latest
## docker inspect fea185a1b31d | grep "IPAddress"

## Command to run Mongo

## docker run --name MongoDB -d 4a3b93a299a7
## sudo docker exec -it MongoDB2(name of container which u gave at run time) bash
## docker run --name MongoDB3(Name which u want) -d -p 127.0.0.1:27017:27017 mongo:3.5(image name)
## docker run --hostname=localhost(Name which u want) -d -p 127.0.0.1:27017:27017 mongo:3.5(image name)
## To connect spring with mongo db on docker both need to run in same network in docker

############################################################################################################

## create a network : docker network create spring-mongodb(network name)
## First need to run mongo db in same network : docker run --net=spring-mongodb  --name mongodb8 -d -p 27017:27017 -t mongo:3.5
## Run docker inspect and check network name and ip address and give same ip address to application.properties
## now run spring boot :docker run --net=spring-mongodb  --name springboot  -p 8081:8081 -t tridentamit/springbootsample1:latest

  


FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.boot.SpringBootSample1Application","--server.port=8081"]
EXPOSE 8081