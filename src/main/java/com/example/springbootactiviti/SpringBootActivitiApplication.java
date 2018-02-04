package com.example.springbootactiviti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springbootactiviti.mapper")
public class SpringBootActivitiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootActivitiApplication.class, args);
	}
}
