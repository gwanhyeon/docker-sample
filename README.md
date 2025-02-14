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
$docker run -d -p 8080:8008 --name docker-sample-container docker-sample
```

> docker container 프로세스 확인

```bash
$docker ps
$docker ps -a (정지된 컨테이너) 
```

> docker container 프로세스 정지 및 삭제

```bash
$docker stop [container ID]
$docker rm [container ID]
````

> docker cli 

```bash
$docker exec --help 
$docker exec -it dockersample_container bash
```

> Minikube & Kubernetes Command Guide

# 1. Minikube 설정 및 시작

### Minikube 클러스터 시작
```bash
minikube start
```

### Minikube 상태 확인
```bash
minikube status
```

### Minikube 환경 설정(windows)
```bash
& minikube -p minikube docker-env | Invoke-Expression
```

# 2. Docker 이미지 빌드

### Docker 이미지 빌드 (Minikube 환경에서 실행)
```bash
docker build -t docker-sample .
```

### Minikube 내부 Docker 환경 사용 설정 (Linux/macOS)
```bash
eval $(minikube docker-env)
```

### Minikube 내부 Docker 환경 사용 설정 (Windows PowerShell)
```bash
& minikube -p minikube docker-env | Invoke-Expression
```

# 3. Kubernetes 리소스 적용 및 삭제

### Kubernetes 리소스 적용 (Service & Deployment)
```bash
kubectl apply -f ./docker-sample-service.yml
kubectl apply -f ./docker-sample-kubectl.yml
```

### Kubernetes 리소스 삭제
```bash
kubectl delete -f ./docker-sample-service.yml
kubectl delete -f ./docker-sample-kubectl.yml
```

# 4. Pod 및 서비스 관리

### pod 목록 조회
```bash
kubectl get pods
```

### 특정 Pod의 상세 정보 확인
```bash
kubectl describe pod docker-sample-bc4746fc7-8llw6
```

### 서비스 목록 조회
```bash
kubectl get services
```

### 포트 포워딩 (로컬 8080 -> Pod 8080)
```bash
kubectl port-forward service/docker-sample-service 8080:8080
```
# 5. Minikube 대시보드 및 서비스

### Minikube 대시보드 실행
```bash
minikube dashboard
```

### Minikube에서 실행 중인 서비스 확인
```bash
minikube service list
```

### 특정 서비스 실행 (로컬 브라우저에서 확인 가능)
```bash
minikube service docker-sample-service
```

# 6. 기타 유용한 명령어

# Kubernetes 클러스터 상태 확인
```bash
kubectl cluster-info
```

### 현재 컨텍스트 및 설정 확인
```bash
kubectl config view
```

### 실행 중인 모든 네임스페이스 보기
```bash
kubectl get namespaces
```

### 특정 네임스페이스의 리소스 보기
```bash
kubectl get all -n kube-system
```

### 실행 중인 모든 파드 로그 확인
```bash
kubectl logs -f <POD_NAME>
```

# 7. Minikube 종료 및 정리

### Minikube 중지
```bash
minikube stop
```
### Minikube 삭제 (클러스터 초기화)
```bash
minikube delete
```
