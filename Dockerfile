FROM openjdk:8-jdk-alpine
EXPOSE 8083
<<<<<<< HEAD
ADD kaddem/kaddem/target/kaddem-0.0.1-SNAPSHOT.jar kaddem.jar
=======
ADD target/kaddem.jar kaddem.jar
>>>>>>> 789716b5e6c75b6141cfd1aebe2564c503c12ecf
ENTRYPOINT ["java","-jar","/kaddem.jar"]
