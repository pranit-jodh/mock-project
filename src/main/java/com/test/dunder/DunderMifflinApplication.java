package com.test.dunder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DunderMifflinApplication {

	public static void main(String[] args) {
		SpringApplication.run(DunderMifflinApplication.class, args);
	}

}
