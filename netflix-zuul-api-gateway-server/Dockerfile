#getting base image
FROM openjdk:8-alpine
MAINTAINER arindam kotal <arikotal@in.ibm.com>
EXPOSE 8765
ADD /target/giphir-zuul-api-gateway-service.jar giphir-zuul-api-gateway-service.jar
ENTRYPOINT ["java", "-jar", "giphir-zuul-api-gateway-service.jar"]