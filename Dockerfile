FROM openjdk:17-alpine as build
LABEL authors="pdr606"

WORKDIR /appSpring
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN apk add maven
WORKDIR /appSpring
RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency;  jar -xf ../*.jar )

FROM openjdk:17 as dev

FROM openjdk:17-alpine
VOLUME /tmp
ARG DEPENDENCY=/appSpring/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java", "-cp", "/app:/app/lib/*", "pdr606.zecodechallengetest"]