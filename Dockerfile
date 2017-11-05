FROM jdk:8

ADD spring-boot-api/build/libs/spring-boot-api-1.0-SNAPSHOT.jar app.jar

RUN sh -c 'touch /app.jar'

ENV JAVA_OPTS="-Xms512M -Xmx2G -Dspring.profiles.active=prd"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]
