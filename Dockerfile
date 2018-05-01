FROM n3ziniuka5/ubuntu-oracle-jdk:16.04-JDK8

RUN apt-get update

ADD ./build/libs/spring-boot-1.0-SNAPSHOT.jar app.jar

RUN sh -c 'touch /app.jar'

ENV JAVA_OPTS="-Xms512M -Xmx2G -Dspring.profiles.active=prd"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]
