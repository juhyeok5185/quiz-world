# 1️⃣ 빌드 환경 설정 (Gradle 사용)
FROM gradle:8-jdk17 AS builder
WORKDIR /app

# 2️⃣ Gradle 캐시를 활용하기 위해 프로젝트에 필요한 파일만 먼저 복사
COPY build.gradle settings.gradle gradle.properties ./
COPY src/main src/main
COPY src/test src/test

# 3️⃣ Gradle 빌드 실행 (캐시 활용, 빌드 속도 최적화)
RUN gradle clean build --no-daemon --parallel -x test

# 4️⃣ 실행 환경 (Slim JDK 사용)
FROM openjdk:17-jdk-slim
WORKDIR /app

# 5️⃣ 빌드된 JAR 파일 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 6️⃣ 포트 설정
EXPOSE 80

# 7️⃣ 컨테이너 실행 시 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
