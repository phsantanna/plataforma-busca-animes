package com.platform.tracking.anime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PlataformaDeBuscaPorAnimesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlataformaDeBuscaPorAnimesApplication.class, args);
	}
    @Bean
    public RestTemplate init(){
        return new RestTemplate();
    }

}
