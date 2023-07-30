package com.bootcamp.bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ApiMonederoMovilApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMonederoMovilApplication.class, args);
	}
	/*
	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkatemplate) {
		return args -> {
			kafkatemplate.send("monederomovil","hello kafka");
		};
	}


	@Bean
	CommandLineRunner commandLineRunner2(KafkaTemplate<String, String> kafkatemplate) {
		return args -> {
			for(int i=0;i<10_000;i++) {
				kafkatemplate.send("monederomovil","hello kafka monederomovil"+i);
			}
		};
	}
	*/


}
