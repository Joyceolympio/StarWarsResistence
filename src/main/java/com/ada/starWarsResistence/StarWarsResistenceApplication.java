package com.ada.starWarsResistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author Aryaovalldo Cleef
 *
 */

@SpringBootApplication
@EntityScan(basePackages = { "com.starwars.api.model" })
public class StarWarsResistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarWarsResistenceApplication.class, args);
	}

}
