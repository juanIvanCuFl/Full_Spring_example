FROM openjdk:8
VOLUME /tmp
ADD ./target/servicio-clientes-0.0.1-SNAPSHOT.jar servicio-clientes.jar
ENTRYPOINT ["java","-jar", "/servicio-clientes.jar"]