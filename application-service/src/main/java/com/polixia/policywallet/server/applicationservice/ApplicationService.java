package com.polixia.policywallet.server.applicationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@ComponentScan("com.polixia.policywallet")
@EnableResourceServer
public class ApplicationService {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationService.class, args);
	}
}
