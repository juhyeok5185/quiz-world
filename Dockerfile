# 빌드 환경 설정 (Gradle 사용)
FROM gradle:8-jdk17 AS builder
WORKDIR /app

# 프로젝트 코드 복사 및 빌드
COPY --chown=gradle:gradle . .
RUN gradle clean build -x test

# 실행 환경 (Slim JDK 사용)
FROM openjdk:17-jdk-slim
WORKDIR /app

# 빌드된 JAR 파일 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 포트 설정 (Spring Boot 기본값 8080)
EXPOSE 80

# 컨테이너 실행 시 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]

#docker build -t quiz-world:latest .
#docker run -d -p 80:80 quiz-world:latest
