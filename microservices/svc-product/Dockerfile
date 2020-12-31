FROM openjdk:11.0.9

EXPOSE 8080

ADD ./target/*.jar svc-product.jar

ENTRYPOINT ["java","-jar","/svc-product.jar"]