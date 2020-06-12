package com.lwl.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lwl.junit.PracticeQuestions;

public class PracticeQuestionsTest {
		
		@BeforeAll
		public static void init() {
			System.out.println("Before all");
		}
		
		@AfterAll
		public static void destory() {
			System.out.println("After all");
		}
		
		@BeforeEach
		public void initMethod() {
			System.out.println("Before each method");
		}
		@AfterEach
		public void destoryMethod() {
			System.out.println("After each method");
		}
	    
		@Test
		public void biggestOfNumbersAisBigTest() {
			PracticeQuestions obj = new PracticeQuestions();
			int res = obj.biggest(10,5,7);
			assertEquals(10, res);
		}
		@Test
		public void biggestOfNumbersBisBigTest() {
			PracticeQuestions obj = new PracticeQuestions();
			int res = obj.biggest(10,15,7);
			assertEquals(15, res);
		}
		
		@Test
		public void biggestOfNumbersCisBigTest() {
			PracticeQuestions obj = new PracticeQuestions();
			int res = obj.biggest(10,5,17);
			assertEquals(17, res);
		}
		
		@Test
		public void biggestOfNumbersEqualnumberTest() {
			PracticeQuestions obj = new PracticeQuestions();
			int res = obj.biggest(15,15,15);
			assertEquals(15, res);
		}
		
		@Test
		public void biggestOfNumbersNveNumberTest() {
			PracticeQuestions obj = new PracticeQuestions();
			int res = obj.biggest(-10,-5,-17);
			assertEquals(-5, res);
		}
		
		@Test
		public void divideWithProperValuesTest() {
			PracticeQuestions obj = new PracticeQuestions();
			int res = obj.divide(10, 2);
			assertEquals(5, res);
		}
		
		@Test
		public void divideWithExcpetionTest() {
			PracticeQuestions obj = new PracticeQuestions();
			assertThrows(IllegalArgumentException.class,()->{obj.divide(10, 0);});
		}
		
		@Test
		@DisplayName("Generating N prime numbers")
		public void primeNumberList() {
			PracticeQuestions obj = new PracticeQuestions();
			List<Integer> list = obj.getPrimeNumbers(5);
			List<Integer> elist = Arrays.asList(2,3,5,7,11);
			assertEquals(elist, list);
		}
		
	
}
