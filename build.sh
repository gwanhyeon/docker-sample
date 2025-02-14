#./gradlew build
#
## 빌드가 성공하면 Docker 이미지 빌드
#if [ $? -eq 0 ]; then
#    echo "Build success. Building Docker image..."
#    docker build -t your-image-name .
#    docker run -d -p 8080:8080 your-image-name
#else
#    echo "Build failed. Docker image will not be created."
#fi