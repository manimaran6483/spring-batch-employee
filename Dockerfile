FROM openjdk:11
EXPOSE 8080
ADD /target/springbatch.jar springbatch.jar 
ENTRYPOINT ["java","-jar","/springbatch.jar"]