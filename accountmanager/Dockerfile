#getting base image
FROM openjdk:8-alpine
MAINTAINER arindam kotal <arikotal@in.ibm.com>
EXPOSE 9200
ADD /target/accountmanager-1.0.jar accountmanager-1.0.jar
ENTRYPOINT ["java", "-jar", "accountmanager-1.0.jar"]