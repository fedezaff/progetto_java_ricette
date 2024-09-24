package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Annotation che indica che questa è un'applicazione Spring Boot
@SpringBootApplication
public class DemoApplication {

    // Metodo principale che avvia l'applicazione Spring Boot
    public static void main(String[] args) {
        // Lancia l'applicazione Spring Boot, utilizzando DemoApplication come classe di configurazione principale
        SpringApplication.run(DemoApplication.class, args);
    }
}
