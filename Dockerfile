from openjdk:10
add target/api-testing-1.0-snapshot.jar api-testing-1.0-snapshot.jar
expose 8085
entrypoint ["java", "-jar","api-testing-1.0-snapshot.jar"]