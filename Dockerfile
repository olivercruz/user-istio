FROM openjdk:8-jre-slim

RUN apt update

RUN apt-get install -y curl

EXPOSE 8990

RUN mkdir /app

COPY build/libs/*.jar /app/user-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap","-jar","/app/user-0.0.1-SNAPSHOT.jar"]