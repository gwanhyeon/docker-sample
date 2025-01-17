# Step 1: 기본 이미지 설정
FROM openjdk:17-jdk-slim AS build

# Step 2: 작업 디렉토리 설정
WORKDIR /app

# Step 3: 프로젝트 JAR 파일 복사
COPY build/libs/docker-sample-0.0.1-SNAPSHOT.jar app.jar

# Step 4: 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]

