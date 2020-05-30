# Run
# On cahnge d'image docker pour avoir notre environnement final sur le jre pour avoir une image plus legere
FROM openjdk:11-jre
ENV MYAPP_HOME /opt/myapp
WORKDIR $MYAPP_HOME
# On recupere les .jar générer dans l'environnement precedent
COPY card-webapp/target/*.jar ./myapp.jar
EXPOSE 8082
ENTRYPOINT java -jar myapp.jar
