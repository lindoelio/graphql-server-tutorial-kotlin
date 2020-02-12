FROM gradle:latest

#COPY . /home/gradle/project

WORKDIR /home/gradle/project

CMD ./gradlew bootRun --info