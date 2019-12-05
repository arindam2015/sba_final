#getting base image
FROM openjdk:8-alpine
MAINTAINER arindam kotal <arikotal@in.ibm.com>
EXPOSE 6078
ADD /target/giphermanager-1.0.jar giphermanager-1.0.jar
ENTRYPOINT ["java", "-jar", "giphermanager-1.0.jar"]