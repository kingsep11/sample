package com.example.springconfig.serv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServApplication.class, args);
	}

}
