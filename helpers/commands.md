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

#### Run Spring Cloud Config
  - minikube start -p=3-deploy-product-service --memory=10240 --cpus=4 --disk-size=30g --vm-driver=virtualbox
  - minikube profile 3-deploy-product-service
  - eval $(minikube docker-env) 
    https://stackoverflow.com/a/48999680/1497737
  - docker build -t spring-cloud-config /Users/samrat.shaw/Development/github/ms-101/microservices/spring-cloud-config
  - docker images (should have the built image)
  - eval $(minikube docker-env -u)
  - kubectl create namespace 3-deploy-product-service
  - kubectl config set-context $(kubectl config current-context) --namespace=3-deploy-product-service
  - kubectl apply -f /Users/samrat.shaw/Development/github/ms-101/kubernetes/3-deploy-product-service/spring-cloud-config/deployment.yaml
  - kubectl apply -f /Users/samrat.shaw/Development/github/ms-101/kubernetes/3-deploy-product-service/spring-cloud-config/service.yaml

#### Run Product Service
  - assumptions 
    - Minikube & spring cloud config is already running
    - The svc-product is pointing to the correct config server (application.properties)
    - The application has been already built once.
    - The correct namespace & context are set in kubectl
  - eval $(minikube docker-env)
  - docker build -t svc-product /Users/samrat.shaw/Development/github/ms-101/microservices/svc-product
  - eval $(minikube docker-env -u)
  - kubectl apply -f /Users/samrat.shaw/Development/github/ms-101/kubernetes/3-deploy-product-service/svc-product/deployment.yaml
  - kubectl apply -f /Users/samrat.shaw/Development/github/ms-101/kubernetes/3-deploy-product-service/svc-product/service.yaml

##### Gotchas
  - Make sure that you build the docker file before deployment. Else the cached build will be containerized.
  - Very important that you map the 
    - server.properties
    - Dockerfile container port
    - Service ports (Nodeport, port & targetPort) properly
   

##### TODO
  - How to build Docker images for the specific environment
