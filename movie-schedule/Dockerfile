# pull image of jdk
FROM java:8-jre

# copy jar file to docker file system
ADD ./target/movie-schedule-0.0.1-SNAPSHOT.jar /usr/app/movie-schedule-0.0.1-SNAPSHOT.jar

# java -jar <jar fileName>
WORKDIR usr/app
ENTRYPOINT ["java","-jar", "movie-schedule-0.0.1-SNAPSHOT.jar"]