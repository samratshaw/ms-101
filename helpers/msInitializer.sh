# Spring initializer
#spring init \
#--boot-version=2.3.7 \
#--build=maven \
#--java-version=11 \
#--packaging=jar \
#--name=product-service \
#--package-name=com.samrat.ms.core \
#--groupId=com.samrat.ms.core \
#--dependencies=web,actuator,lombok \
#--version=1.0.0 \
#product-service

# Config Server
spring init \
--boot-version=2.3.7 \
--build=maven \
--java-version=11 \
--packaging=jar \
--name=spring-config-server \
--package-name=com.samrat.ms.core \
--groupId=com.samrat.ms.core \
--dependencies=web,actuator,cloud-config-server \
--version=1.0.0 \
spring-config-server