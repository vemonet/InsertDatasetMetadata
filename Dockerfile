FROM maven:3-jdk-8

WORKDIR /tmp

COPY . .

RUN mvn clean install && \
    mkdir /app && \
    cp target/DescriptiveStatistics-1.0.0-jar-with-dependencies.jar /app
    
WORKDIR /app

ENTRYPOINT ["java","-jar","DescriptiveStatistics-1.0.0-jar-with-dependencies.jar"]