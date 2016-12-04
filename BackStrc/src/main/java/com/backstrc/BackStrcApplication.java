package com.backstrc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@ComponentScan("com.*")
@EnableJpaRepositories("com.*")
@EntityScan("com.*")
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BackStrcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackStrcApplication.class, args);
	}
}
