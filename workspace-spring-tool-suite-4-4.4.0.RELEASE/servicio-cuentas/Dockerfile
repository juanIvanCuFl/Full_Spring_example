FROM openjdk:8
VOLUME /tmp
ADD ./target/servicio-cuentas-0.0.1-SNAPSHOT.jar servicio-cuentas.jar
ENTRYPOINT ["java","-jar", "/servicio-cuentas.jar"]