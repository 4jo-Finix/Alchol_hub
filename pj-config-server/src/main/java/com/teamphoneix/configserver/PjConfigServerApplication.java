package com.teamphoneix.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PjConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PjConfigServerApplication.class, args);
	}

}
