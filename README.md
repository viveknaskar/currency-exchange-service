# Currency Exchange Service

This service is one of the many services developed for demonstrating microservice architecture with Feign REST Client, Eureka Server, Spring Cloud Load balancer, Spring Cloud API gateway, Resilience4j and Circuit breaker features.

## Some commands for running docker

Docker images can be created if the application has the below dependency:

```
<build>
  <plugins>
    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
    </plugin>
  </plugins>
</build>
```

### For building docker image
```
mvn spring-boot:build-image -DskipTests=true
```

### For verifying the docker image
```
docker images
```

### For running the docker image as container
```
docker run -p 8000:8000 -d <docker-image-name:tag-name>
```

### For verifying the container running
```
docker ps
```

### For verifying all the running/stopped containers
```
docker ps -a
```

### For deleting all stopped/exited containers
```
docker container prune
```


