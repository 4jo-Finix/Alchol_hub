package com.teamphoenix;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class AhubPostAndNewsApplication {


	public static void main(String[] args) {
		SpringApplication.run(AhubPostAndNewsApplication.class, args);
	}

	@Bean
	public static ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
