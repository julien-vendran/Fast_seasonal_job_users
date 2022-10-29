# Docker
Pour mettre en place Docker, on commence par générer le jar de l'application
```shell
 ./gradlew build
```
*A partir de cette étape, il faut avoir lancer Docker*  
Une fois le jar généré, il faut créer l'image Docker
```shell
docker build -t fast_seasonal_job/users . 
```

Il faut ensuite lancer un container à partir de cette image
```shell
docker run -p 8080:8080 fast_seasonal_job/users
```