# Use a lightweight base image with OpenJDK 21 preinstalled
FROM eclipse-temurin:21-jdk-alpine

# Imposta la directory di lavoro
WORKDIR /app

# Copia il file JAR del tuo progetto
COPY target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Espone la porta su cui il tuo server Spring ascolterà
EXPOSE 8080

# Comando per eseguire l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]
