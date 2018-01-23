FROM maven:3-jdk-8

WORKDIR /tmp/dqa

COPY . .

RUN mvn clean install && \
    mkdir /app && \
    mv target/DescriptiveStatistics-1.0.0-jar-with-dependencies.jar /app && \
    rm -rf /tmp/dqa
    
WORKDIR /app

ENTRYPOINT ["java","-jar","DescriptiveStatistics-1.0.0-jar-with-dependencies.jar"]
