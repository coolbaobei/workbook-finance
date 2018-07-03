FROM index.tinyvoice.net/basic_images/jdk:1.8
MAINTAINER wenlong.pu wenlong.pu@changhong.com"
COPY ./target/workbook-report-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
ENTRYPOINT java ${JAVA_OPTS} ${DENV} -Djava.security.egd=file:/dev/./urandom -jar ./app.jar
