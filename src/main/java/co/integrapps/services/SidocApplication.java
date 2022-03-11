package co.integrapps.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EntityScan("co.integrapps.services.adapters.persistence")
@EnableCaching
@EnableScheduling
@EnableWebSecurity
public class SidocApplication {
	public static void main(String[] args) {
		SpringApplication.run(SidocApplication.class, args);
	}

}
