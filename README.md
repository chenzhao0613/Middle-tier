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

## Running Middle Tier Through Google Kubernetes Engine
* Go to Kubernetes Engine and click "Create Cluster".

![Kubectl 1](https://user-images.githubusercontent.com/38166320/67878161-3bee4e80-fb11-11e9-87e0-c8662c4ef5dd.png)

![Kubectl 2](https://user-images.githubusercontent.com/38166320/67883823-241bc800-fb1b-11e9-9548-832cb4ebc19d.png)

* Config cluster
    * Rename cluster if desired.
    * Keep location type as zonal.
    * Change zone if desired.
    * Change number of nodes to 1 or more. For our case, we decided to stick with 1 node.
    * Keep rest of settings alone.
    * Click Create (Might take a few minutes for cluster to be ready)

![Kubectl 3](https://user-images.githubusercontent.com/38166320/67883945-59c0b100-fb1b-11e9-8bae-bcca351db278.png)

* Click button labeled "Connect" to access Kubernetes cluster and then click "Run in Cloud Shell". You may also access the cluster via your Terminal by copying the command above. 

![Kubectl 4](https://user-images.githubusercontent.com/38166320/67909790-e50b6800-fb56-11e9-9e0c-5b7b6881fa5e.png)

![Kubectl 5](https://user-images.githubusercontent.com/38166320/67909900-4c291c80-fb57-11e9-9f3c-4a4b46792f56.png)

* Use the command ```git clone https://github.com/Exsects/fedex-middle-tier.git``` in the Cloud Shell. 

* Switch to GKE branch using ```git checkout gke```.

* Spin up the deployments and services as well as the load balancer through the command ```kubectl apply -f deployment-mysql.yml && kubectl apply -f deployment.yml```.

* To check the status of pods, services, deployments and load balancer, you can use the command ```kubectl get all```.

* From the command ```kubectl get all```, within the line that displays "service/middletier-lb" we can see that the External IP address is ready to be accessed. Please note that you may see it being pending as it takes a few minutes for the load balancer to generate an External IP addresss.

![Kubectl 6](https://user-images.githubusercontent.com/38166320/67910788-7b8d5880-fb5a-11e9-919a-9598410cb47c.png)

* We can now access our middle tier through our browser by typing in our browser the \<EXTERNAL IP ADDRESS>\:60000. You should be able to see brackets when you land on the page.

![Kubectl 7](https://user-images.githubusercontent.com/38166320/67910800-8811b100-fb5a-11e9-95d8-e565e0996e9f.png)