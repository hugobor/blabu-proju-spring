package com.github.hugobor.blabu_proju_spring;

import java.text.MessageFormat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Benes {

	@GetMapping("/hello")
	public String hello(@RequestParam(name="name", defaultValue="Mundo") String name) {
		return MessageFormat.format("Olá, {0}!!!!", name);
	}
	
}
