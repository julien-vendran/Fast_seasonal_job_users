# Docker
## Spring
Pour mettre en place Docker, on commence par générer le jar de l'application
```shell
./gradlew build
```
*A partir de cette étape, il faut avoir lancer Docker*  
Une fois le jar généré, il faut créer l'image Docker
```shell
sudo docker build -t fast_seasonal_job/users . 
```

Il faut ensuite lancer un container à partir de cette image
```shell
docker run --name server -p 8081:8081 fast_seasonal_job/users
```

## Postgres 
Pour avoir accès aux données, il faut créer une base de données postgresql dans docker 
```shell
docker run --name postgres-db -e POSTGRES_PASSWORD=docker -p 5432:5432 -d postgres
```
Host: *localhost*  
Port: *5432*  
User: *postgres*  
Password: *docker*  

Pour accéder au terminal du container depuis un terminal
```shell
docker exec -it <container-name> bash
```

# Keycloak 
Lancer une instance de KeyCloak
```shell
docker run --name keycloak -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:20.0.1 start-dev
```