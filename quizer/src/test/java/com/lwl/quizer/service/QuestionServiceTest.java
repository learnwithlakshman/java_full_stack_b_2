package com.lwl.quizer.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuestionServiceTest {

	@Autowired
	private QuestionService questionService;

	@Test
	void biggestAsFirstNumber() {
		int res = questionService.biggest(10, 8, 5);
		Assertions.assertThat(res).isEqualTo(10);
	}

	@Test
	void biggestAsSecondNumber() {
		int res = questionService.biggest(10, 18, 5);
		Assertions.assertThat(res).isEqualTo(18);
	}

	@Test
	void biggestAsThridNumber() {
		int res = questionService.biggest(10, 8, 25);
		Assertions.assertThat(res).isEqualTo(25);
	}

	@Test
	void generatePrimesTest() {
		List<Integer> res = questionService.getPrimeInRange(1, 10); // 1,2,3,5,7
		Assertions.assertThat(res).size().isEqualTo(5);
	}

	@Test
	void generatePrimesNnumbersTest() {
		List<Integer> res = questionService.getPrimeInRange(-1, -10);
		Assertions.assertThat(res).size().isEqualTo(0);
	}

}
