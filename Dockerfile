FROM openjdk:8-alpine
MAINTAINER "Ukange Ushahemba <ukange1984@gmail.com>"
# Define working directory.
WORKDIR /work
ADD target/card-bin-verification-service-0.0.1-SNAPSHOT.jar /work/card-bin-verification-service-0.0.1-SNAPSHOT.jar
# Expose Ports
EXPOSE 8081

ENTRYPOINT exec java -jar /work/card-bin-verification-service-0.0.1-SNAPSHOT.jar --spring.config.location=/properties/application.properties