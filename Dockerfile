# Étape 1 : construire l'application
FROM maven:3.9.2-eclipse-temurin-17 AS build

# Définit le répertoire de travail
WORKDIR /app

# Copie les fichiers Maven
COPY pom.xml .
COPY src ./src

# Compile le projet et package en jar exécutable
RUN mvn clean package -DskipTests

# Étape 2 : créer l'image finale
FROM eclipse-temurin:17-jdk-jammy

# Définir le répertoire de l'application dans l'image
WORKDIR /app

# Copier le jar depuis l'étape build
COPY --from=build /app/target/SmartFinger_Inscription-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port de l'application Spring Boot
EXPOSE 8080

# Commande pour lancer l'application
ENTRYPOINT ["java","-jar","/app/app.jar"]
