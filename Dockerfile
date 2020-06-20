# cache as most as possible in this multistage dockerfile.
FROM maven:3.6.3-jdk-11 AS deps

WORKDIR /opt/app

COPY domain/pom.xml domain/pom.xml
COPY http-commons/pom.xml http-commons/pom.xml
COPY entry-request-handler/pom.xml entry-request-handler/pom.xml
COPY api-gateway/pom.xml api-gateway/pom.xml
COPY registration-service/pom.xml registration-service/pom.xml
COPY status-service/pom.xml status-service/pom.xml
COPY entry-service/pom.xml entry-service/pom.xml
COPY exit-service/pom.xml exit-service/pom.xml
COPY client/pom.xml client/pom.xml

COPY pom.xml .
RUN mvn -B -e -C org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline
#-DexcludeArtifactIds=domain,http-commons

# if you have modules that depends each other, you may use -DexcludeArtifactIds as follows
# RUN mvn -B -e -C org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline -DexcludeArtifactIds=module1
# else
# RUN mvn -B -e -C org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline

# Copy the dependencies from the DEPS stage with the advantage
# of using docker layer caches. If something goes wrong from this
# line on, all dependencies from DEPS were already downloaded and
# stored in docker's layers.
FROM deps AS builder
WORKDIR /opt/app
COPY --from=deps /root/.m2 /root/.m2
COPY --from=deps /opt/app/ /opt/app

COPY domain/src /opt/domain/src
COPY http-commons/src /opt/http-commons/src
COPY entry-request-handler/src /opt/entry-request-handler/src
COPY api-gateway/src /opt/api-gateway/src
COPY registration-service/src /opt/registration-service/src
COPY status-service/src /opt/status-service/src
COPY entry-service/src /opt/entry-service/src
COPY exit-service/src /opt/exit-service/src
COPY client/src /opt/client/src

# use -o (--offline) if you didn't need to exclude artifacts.
# if you have excluded artifacts, then remove -o flag
RUN mvn -B -e -o clean install -DskipTests=true

# At this point, BUILDER stage should have your .jar or whatever in some path
FROM openjdk:14.0.1-jdk
WORKDIR /opt/app
COPY --from=builder /opt/app/target/reboarding.jar .
EXPOSE 8080
CMD [ "java", "-jar", "/opt/app/reboarding.jar" ]