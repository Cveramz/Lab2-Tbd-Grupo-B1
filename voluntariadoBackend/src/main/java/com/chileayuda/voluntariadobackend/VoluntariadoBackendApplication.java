package com.chileayuda.voluntariadobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:5173")
public class VoluntariadoBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoluntariadoBackendApplication.class, args);
    }

}
