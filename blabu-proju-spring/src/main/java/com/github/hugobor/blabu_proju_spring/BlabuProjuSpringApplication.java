package com.github.hugobor.blabu_proju_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.hugobor.blabu_proju_spring.model.Platform;

@SpringBootApplication
public class BlabuProjuSpringApplication {

	@Repository
	public static interface PRepository extends CrudRepository<Platform, Long> {
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(BlabuProjuSpringApplication.class, args);
	}

}
