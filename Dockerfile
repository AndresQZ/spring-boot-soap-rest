#Start with a base image containing Java runtime
FROM openjdk:11-slim as build

# The application's jar file
ARG JAR_FILE

# Add the application's jar to the container
COPY ${JAR_FILE} fatJar.jar

EXPOSE 8008
ENV PORT 8008

ENTRYPOINT ["java","-jar","/fatJar.jar"]