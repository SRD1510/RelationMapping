package com.example.RBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//This application impelented using JPA and having one-one,one-many,many-many relations of user -->address,user <--> roles
@SpringBootApplication(scanBasePackages = { "com.example.RBD" })
public class RbdApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbdApplication.class, args);
	}

}
