## [Bootstrap Product Service](https://github.com/samratshaw/ms-101/issues/2)

##### Run MS app

- mvn -Pcentral clean package spring-boot:run
    - Bit weird that it throws an error when running in Intellij
    - Intellij does not build the app before running the app :/


##### TODO

  - With git server the spring-config server did not work. This is important to make sure that configuration does not reside in the classpath.
  - Did not configure MS to retry multiple times for getting the config from server
  - How to auto-refresh the properties of MS without restarting MS (need to research about actuator refresh)

## [Deploy Product Service](https://github.com/samratshaw/ms-101/issues/3)

#### Build docker image
  - mvn -Pcentral clean package spring-boot:repackage
  - docker build -t spring-config-server .

#### Run in minikube
  - minikube start -p=3-deploy-product-service --memory=10240 --cpus=4 --disk-size=30g --vm-driver=virtualbox
  - minikube profile 3-deploy-product-service
  - eval $(minikube docker-env) 
    https://stackoverflow.com/a/48999680/1497737
  - docker build -t spring-config-server /Users/samrat.shaw/Development/github/ms-101/microservices/spring-config-server
  - docker images (should have the built image)
  - eval $(minikube docker-env -u)
  - kubectl create namespace 3-deploy-product-service
  - kubectl config set-context $(kubectl config current-context) --namespace=3-deploy-product-service
  - kubectl apply -f /Users/samrat.shaw/Development/github/ms-101/kubernetes/3-deploy-product-service/spring-config-server/deployment.yaml
  - kubectl apply -f /Users/samrat.shaw/Development/github/ms-101/kubernetes/3-deploy-product-service/spring-config-server/service.yaml

##### Gotchas
  - Make sure that you build the docker file before deployment. Else the cached build will be containerized.
  - Very important that you map the 
    - server.properties
    - Dockerfile container port
    - Service ports (Nodeport, port & targetPort) properly
   

##### TODO
  - How to build Docker images for the specific environment
