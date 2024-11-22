FROM frolvlad/alpine-oraclejdk8:slim
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/myservice.jar"]
VOLUME /tmp
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/myservice/myservice.jar

