#getting base image
FROM openjdk:8-alpine
MAINTAINER arindam kotal <arikotal@in.ibm.com>
EXPOSE 6082
ADD /target/gipherrecommendersystem-1.0.jar gipherrecommendersystem-1.0.jar
ENTRYPOINT ["java", "-jar", "gipherrecommendersystem-1.0.jar"]