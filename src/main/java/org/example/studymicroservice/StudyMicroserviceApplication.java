package org.example.studymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StudyMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyMicroserviceApplication.class, args);
    }

}
