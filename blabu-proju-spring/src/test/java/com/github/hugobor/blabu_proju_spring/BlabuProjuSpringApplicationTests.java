package com.github.hugobor.blabu_proju_spring;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlabuProjuSpringApplicationTests {

	@Test
	void contextLoads() {
		assertFalse(true == "".isBlank());
	}

}
