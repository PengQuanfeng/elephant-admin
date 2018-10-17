package com.drelephant.elephantadmin.business.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableFeignClients
public class ElephantadminBusinessModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElephantadminBusinessModuleApplication.class, args);
	}
}
