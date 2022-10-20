FROM openjdk:17
WORKDIR /home/app
COPY db_migrations /home/app/db_migrations
COPY build/libs/hibernate-demo-0.1-all.jar /home/app/
COPY src/main/resources /home/app/
CMD ["java", "-Dmicronaut.environments=foo" , "-jar", "hibernate-demo-0.1-all.jar"]