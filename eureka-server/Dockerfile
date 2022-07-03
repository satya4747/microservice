FROM lpicanco/java11-alpine:11.0

ENV DEPLOY_DIR /deployments

RUN mkdir -p ${DEPLOY_DIR}
RUN mkdir -p ${DEPLOY_DIR}/logs

RUN chmod -R 777 ${DEPLOY_DIR}

WORKDIR ${DEPLOY_DIR}

COPY /target/eureka*.jar ${DEPLOY_DIR}/app.jar

CMD ["java", "-jar", "/deployments/app.jar"]