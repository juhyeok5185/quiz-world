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

EXPOSE 80

ENTRYPOINT ["java", "-jar", "app.jar"]

#docker build -t quiz-world:latest .
#docker run -d -p 80:80 quiz-world:latest