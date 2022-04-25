FROM openjdk:11 as build
EXPOSE 8787
ADD /target/ONI-API-0.0.1-SNAPSHOT.jar oni-dgi-api.jar
ENTRYPOINT ["java", "-jar", "oni-dgi-api.jar"]


#java.net.UnknownHostException: nis.hti.dermalog.site