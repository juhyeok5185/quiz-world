# 빌드 단계
FROM gradle:7.6.2-jdk17 AS builder

# Gradle 캐시 최적화 (불필요한 전체 파일 복사 방지)
WORKDIR /app
COPY gradle/ gradle/
COPY gradlew .
COPY settings.gradle .
COPY build.gradle .

# Gradle 실행 시 메모리 최적화
ENV GRADLE_OPTS="-Xmx512m -Dorg.gradle.daemon=false"

# Gradle 종속성 캐시 미리 다운로드 (빌드 속도 향상)
RUN ./gradlew dependencies --no-daemon

# 프로젝트 전체 복사 후 빌드 실행
COPY . .
RUN ./gradlew clean build --no-daemon -x test

# 실행 단계
FROM openjdk:17-jdk-slim

WORKDIR /app

# 빌드한 JAR 파일 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# Java 실행 시 메모리 최적화 옵션 추가
ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:+UseContainerSupport -XX:ActiveProcessorCount=2"

# 애플리케이션 실행
EXPOSE 80
ENTRYPOINT ["java", "-jar", "app.jar"]


#docker build -t quiz-world:latest .
#docker run -d -p 80:80 quiz-world:latest