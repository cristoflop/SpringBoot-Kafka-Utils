## Herramienta para monitorear instancias de kafka

* Necesario tener una instancia de kafka ejecutandose

#### Para ejecutar en local:

* En el fichero application.properties modificar las variables de entorno `SPRING_KAFKA_BOOTSTRAP_SERVERS` y `SPECIFIC_CONSUMER_GROUP` con los parametros del docker que se quiera

#### Para ejecutar en docker

* Primero modificar el .yaml para levantar el contenedor con las mismas variables de entorno
* Generar imagen de docker con `mvn spring-boot:build-image` -- Genera imagen de docker en local con `<artifactId>:<version>`
* Levantar contenedor: `docker-compose -d -f kafka-topics-utils-stack.yaml up --build`