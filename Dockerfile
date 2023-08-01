FROM openjdk:17-jdk-alpine
RUN mkdir /app
WORKDIR /app
COPY target/*.jar /app/api-monedero-movil-0.0.1-SNAPSHOT.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","api-monedero-movil-0.0.1-SNAPSHOT.jar"]


