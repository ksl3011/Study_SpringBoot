package com.edu.cmn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.edu.mapper")
public class SpringbootStudy01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudy01Application.class, args);
	}

}
