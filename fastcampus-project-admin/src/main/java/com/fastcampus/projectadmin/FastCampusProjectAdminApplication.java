package com.fastcampus.projectadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class FastCampusProjectAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastCampusProjectAdminApplication.class, args);
	}

}
