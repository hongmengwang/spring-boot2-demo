FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD target/${JAR_FILE} app.jar
ENV JAVA_ARGS="-Xms1G" SPRING_BOOT_ARGS="--spring.profiles.active=dev"
ENTRYPOINT [ "sh", "-c", "java ${JAVA_ARGS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar ${SPRING_BOOT_ARGS}" ]
