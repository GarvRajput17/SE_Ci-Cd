FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the built JAR from the Maven target directory into the image.
# In Jenkins this assumes 'mvn package' has already been run.
COPY target/ci-cd-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

