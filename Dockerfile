FROM --platform=linux/amd64 adoptopenjdk/openjdk11
COPY ./build/libs/sidoc-0.0.1-SNAPSHOT.jar sidoc-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","sidoc-0.0.1-SNAPSHOT.jar"]