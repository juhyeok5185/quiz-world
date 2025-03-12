# 1️⃣ 빌드 환경 설정 (Gradle 사용)
FROM gradle:8-jdk17 AS builder
WORKDIR /app

# 2️⃣ 프로젝트 전체 복사 후 빌드 실행
COPY . .
RUN gradle clean build --no-daemon --parallel -x test

# 3️⃣ 실행 환경 (Slim JDK 사용)
FROM openjdk:17-jdk-slim
WORKDIR /app

# 4️⃣ 빌드된 JAR 파일 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 5️⃣ 포트 설정
EXPOSE 80

# 6️⃣ 컨테이너 실행 시 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
