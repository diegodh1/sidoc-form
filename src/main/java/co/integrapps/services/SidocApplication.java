package co.integrapps.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EntityScan("co.integrapps.services.adapters.persistence")
@EnableCaching
@EnableScheduling
public class SidocApplication {
	public static void main(String[] args) {
		SpringApplication.run(SidocApplication.class, args);
	}

}
