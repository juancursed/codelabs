package com.example.ejercicioclase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EjercicioClaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(EjercicioClaseApplication.class, args);
    }

}
