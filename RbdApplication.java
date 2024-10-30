package com.example.RBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = { "com.example.RBD" })

public class RbdApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbdApplication.class, args);
	}

}
