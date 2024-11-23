FROM eclipse-temurin:17-jdk
WORKDIR /opt
COPY target/foodcatalogue-0.0.1-SNAPSHOT.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar