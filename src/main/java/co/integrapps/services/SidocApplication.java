package co.integrapps.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("co.integrapps.services.adapters.persistence")
public class SidocApplication {
	public static void main(String[] args) {
		SpringApplication.run(SidocApplication.class, args);
	}
}
