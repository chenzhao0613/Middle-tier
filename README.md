# FedEx Middle Tier Capstone Project
## Table of Contents
* [Technologies](#technologies)
* [Running Middle Tier Through docker-compose](#running-middle-tier-through-docker-compose)
* [Running Middle Tier Through MiniKube](#running-middle-tier-through-minikube)
* [Running Middle Tier Through Google Kubernetes Engine](#running-middle-tier-through-google-kubernetes-engine)

## Technologies
* Spring Boot (Maven)
* mySQL
* Docker
* Kubernetes
* VirtualBox
* MiniKube (used to test Kubernetes locally)

## Running Middle Tier Through docker-compose
* Install Maven

* Change your directory to the fedex-middle-tier folder and use the command ``` mvn install -DskipTests ```.

* To run our middle tier, we can use the command ``` docker-compose up ``` to start up two containers, one for mySQL and the other for the Spring Boot application.

* To turn off the containers, we can use the command ```docker-compose stop```.

* To turn off and delete the containers, we can use the command ```docker-compose down```.

## Running Middle Tier Through MiniKube
* Install VirtualBox if not already installed.

* Install Kubernetes and MiniKube.

* To start up Minikube cluster, we use the command ```minikube start```.

* Use the command ```eval $(minikube docker-env)``` which will enable you to build the middle-tier the image onto the MiniKube /cluster.

* Use the command ```docker image build -t fedex-middle-tier .``` which will build the image.

* Spin up the deployments and services through the command ```kubectl apply -f deployment-mysql.yml && kubectl apply -f deployment.yml```.

* To check the status of pods, services, and deployments, you can use the command ```kubectl get all```.

* If everything seems to be ok and running, we can test our application by using the command ```minikube service middletier-container``` which will open up the URL for the middle tier in your default browser. 

* To delete the MiniKube cluster, use the command ```minikube delete```.
