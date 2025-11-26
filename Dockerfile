FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the built JAR from the Maven target directory into the image.
# In Jenkins this assumes 'mvn package' has already been run.
COPY target/todo-cli-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

