package com.mit;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mit.*")
public class MitDemoApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(MitDemoApplication.class, args);
	}
}
