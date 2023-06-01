package com.example.ejercicioDeportistasDTO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.ejercicioDeportistasDTO")
public class EjercicioDeportistasDtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioDeportistasDtoApplication.class, args);
	}

}
