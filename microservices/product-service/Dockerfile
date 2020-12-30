FROM openjdk:11.0.9

EXPOSE 8080

ADD ./target/*.jar product-service.jar

ENTRYPOINT ["java","-jar","/product-service.jar"]