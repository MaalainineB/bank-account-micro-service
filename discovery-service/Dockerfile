FROM openjdk:17-oracle
VOLUME /tmp
COPY target/discovery-service-0.0.1-SNAPSHOT.jar app.jar
#COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]