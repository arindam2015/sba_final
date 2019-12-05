#getting base image
FROM openjdk:8-alpine
MAINTAINER arindam kotal <arikotal@in.ibm.com>
EXPOSE 8761
ADD /target/gipher-eureka-naming-server.jar gipher-eureka-naming-server.jar
ENTRYPOINT ["java", "-jar", "gipher-eureka-naming-server.jar"]