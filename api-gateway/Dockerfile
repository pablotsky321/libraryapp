FROM sapmachine:22-jdk-headless-ubuntu
COPY target/*.jar api-gateway.jar
EXPOSE 8080
CMD ["java","-jar","api-gateway.jar"]