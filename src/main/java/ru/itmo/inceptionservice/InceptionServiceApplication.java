package ru.itmo.inceptionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itmo.inceptionservice.utils.generator.EntityGenerator;

@SpringBootApplication
public class InceptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InceptionServiceApplication.class, args);
	}

}
