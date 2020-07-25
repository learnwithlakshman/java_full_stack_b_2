package com.lwl.quizer.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Override
	public List<Integer> getPrimeInRange(int lb, int ub) {
		return IntStream.rangeClosed(lb, ub).boxed().filter(QuestionServiceImpl::isPrime).collect(Collectors.toList());
	}

	@Override
	public int biggest(int a, int b, int c) {
		if (a > b && a > c)
			return a;
		else if (b > c) {
			return b;
		}
		return c;
	}

	@Override
	public boolean isPalindrome(int num) {
		int rev = 0;
		int temp = num;
		while (num != 0) {
			rev = rev * 10 + num % 10;
			num /= 10;
		}
		return temp == rev;
	}

	private static boolean isPrime(int num) {
		if (num < 1) {
			return false;
		}
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
