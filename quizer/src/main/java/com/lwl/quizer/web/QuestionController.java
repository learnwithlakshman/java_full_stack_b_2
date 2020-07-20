package com.lwl.quizer.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwl.quizer.service.QuestionService;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@GetMapping("/primes/{lb}/{ub}")
	public List<Integer> getPrimeInRange(@PathVariable("lb") int lb, @PathVariable("ub") int ub) {
		return questionService.getPrimeInRange(lb, ub);

	}

	@GetMapping("/isprime/{num}")
	public boolean isPrime(@PathVariable("num") int num) {
		return questionService.isPalindrome(num);

	}

	@GetMapping("/biggest/{num1}/{num2}/{num3}")
	public int getPrimeInRange(@PathVariable("num1") int num1, @PathVariable("num2") int num2,
			@PathVariable("num3") int num3) {
		return questionService.biggest(num1, num2, num3);

	}
}
