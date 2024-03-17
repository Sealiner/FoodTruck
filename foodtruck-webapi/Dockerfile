ARG REPO_ADDR
FROM ${REPO_ADDR}/library/base-jre8:1.0
VOLUME /tmp
ARG JAR_FILE
ADD target/${JAR_FILE} /app.jar
EXPOSE 8888
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
