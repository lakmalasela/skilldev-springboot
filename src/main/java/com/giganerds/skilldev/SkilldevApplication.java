package com.giganerds.skilldev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.giganerds.skilldev")
public class SkilldevApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkilldevApplication.class, args);
		System.out.println("This is Skill Deve Programe");
	}

}
