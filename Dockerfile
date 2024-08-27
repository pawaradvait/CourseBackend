FROM openjdk:17-jdk
COPY target/Course-App-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "Course-App-0.0.1-SNAPSHOT.jar" ]