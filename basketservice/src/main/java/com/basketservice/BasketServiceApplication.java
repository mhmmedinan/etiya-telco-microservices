package com.basketservice;

import com.etiya.common.annotations.EnableSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableSecurity
@EnableDiscoveryClient
public class BasketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasketServiceApplication.class, args);
	}

}
