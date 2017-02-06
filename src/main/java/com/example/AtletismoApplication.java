package com.example;

import com.example.service.AtletaService;
import com.example.service.MedallasService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AtletismoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AtletismoApplication.class, args);

		AtletaService atletaService = context.getBean(AtletaService.class);
		MedallasService medallaService = context.getBean(MedallasService.class);

		atletaService.crearAtleta();
		atletaService.testAtleta();


		medallaService.crearMedalla();
		medallaService.testMedalla();



	}
}
