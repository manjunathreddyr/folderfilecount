package com.solstis.i2rfilecount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class I2rFileCountApplication {

	public static void main(String[] args) {
		SpringApplication.run(I2rFileCountApplication.class, args);
	}

}
