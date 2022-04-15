FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.10_9_openj9-0.24.0
COPY ./build/libs/sidoc-0.0.1-SNAPSHOT.jar sidoc-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","sidoc-0.0.1-SNAPSHOT.jar"]