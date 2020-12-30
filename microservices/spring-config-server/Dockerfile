FROM openjdk:11.0.9

EXPOSE 8080

ADD ./target/*.jar spring-config-server.jar

ENTRYPOINT ["java","-jar","/spring-config-server.jar"]