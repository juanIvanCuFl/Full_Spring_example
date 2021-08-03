FROM openjdk:8
VOLUME /tmp
ADD ./target/servicio-customerse-0.0.1-SNAPSHOT.jar servicio-customerse.jar
ENTRYPOINT ["java","-jar", "/servicio-customerse.jar"]