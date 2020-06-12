package com.lwl.junit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class PracticeQuestions {
	
	public void showResult() {
		int a = 10, b = 20;
		if (a < b)
			System.out.println(a);
		    System.out.println(b);
	}

	public int biggest(int a, int b, int c) {
		if (a > b && a > c)
			return a;
		else if (b > c)
			return b;
		else
			return c;
	}

	public int biggest(int... a) {
		int big = 0;
		TreeSet<Integer> set = new TreeSet<>();
		Collections.addAll(Arrays.asList(a), set);
		big = set.last();
		return big;

	}

	public int divide(int a, int b) {
		int res = 0;
		if (b == 0) {
			throw new IllegalArgumentException("Second argument can not be zero");
		}
		res = a / b;
		return res;
	}

	public boolean isPrime(int num) {
		if (num <= 1)
			return false;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public boolean palindrome(String str) {
		if (str != null) {
			return new StringBuffer(str).reverse().toString().equals(str);
		}
		return false;
	}

	public List<Integer> getPrimeNumbers(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 2;; i++) {
			if (list.size() == n) {
				break;
			}
			if (isPrime(i)) {
				list.add(i);

			}
		}
		return list;
	}
}
