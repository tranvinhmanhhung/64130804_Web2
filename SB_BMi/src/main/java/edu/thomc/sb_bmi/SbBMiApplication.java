package edu.thomc.sb_bmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "controllers")
public class SbBMiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbBMiApplication.class, args);
	}

}
