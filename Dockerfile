FROM openjdk:8-jre-alpine
MAINTAINER guxiaotu<524343695@qq.com>
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8888