# 빌드
FROM gradle:7.6.2-jdk17 AS builder

WORKDIR /app
COPY . .

RUN gradle clean build --no-daemon -x test

# 실행
FROM openjdk:17-jdk-slim

WORKDIR /app

# 빌드한 JAR 파일 복사
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

#서버로 보내는 법
#docker buildx build --platform linux/amd64 -t quiz-world:latest --output type=docker,dest=quiz-world.tar .
#scp quiz-world.tar danny@203.245.30.75:/home/danny/image-tar-file/
#1q2w3e4r
#rm quiz-world.tar

#서버에서
#docker stop quiz-world 2>/dev/null || true
#docker rm quiz-world 2>/dev/null || true
#docker load -i /home/danny/image-tar-file/quiz-world.tar
#rm /home/danny/image-tar-file/quiz-world.tar
#docker run -d -p 8080:8080 --name quiz-world quiz-world:latest
##