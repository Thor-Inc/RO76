package com.sda.JUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class JUnitApplication {

	public static void main(String[] args) {
		SpringApplication.run(JUnitApplication.class, args);
	}

}
