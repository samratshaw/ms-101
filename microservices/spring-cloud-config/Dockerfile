FROM openjdk:11.0.9

EXPOSE 8080

ADD ./target/*.jar spring-cloud-config.jar

ENTRYPOINT ["java","-jar","/spring-cloud-config.jar"]