### aks 미니랩스 실습 

> Springboot jar 파일 생성 

```bash
gradle : jar
$gradlew build

maven : war
$mvn clean package 
```

> Dockerfile 

```shell
FROM openjdk:17-jdk-slim AS build
WORKDIR /app
COPY build/libs/docker-sample-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

> docker 이미지 생성
 
```bash
$docker build -t docker-sample .
```

>  docker 이미지 확인

```bash
$docker images
```

> docker container 구동

```bash
docker run -d -p 8080:8008 --name docker-sample-container docker-sample
```

> docker container 프로세스 확인

```bash
docker ps
docker ps -a (정지된 컨테이너) 
```

> docker container 프로세스 정지 및 삭제
> 
```bash
docker stop [container ID]
docker rm [container ID]
````

> docker cli 

```bash
docker exec --help 
docker exec -it dockersample_container bash
```


