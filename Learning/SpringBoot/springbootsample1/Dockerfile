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
## command to create image :./mvnw install dockerfile:build
## command to run image to docker : docker run -p 8081:8081 -t tridentamit/springbootsample1:latest

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.boot.SpringBootSample1Application"]