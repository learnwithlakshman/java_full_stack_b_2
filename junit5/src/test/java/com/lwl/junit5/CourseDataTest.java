package com.lwl.junit5;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.lwl.junit.CSVManager;
import com.lwl.junit.CourseData;
//import com.lwl.junit.JSONManager;

class CourseDataTest {
	// private static JSONManager JM ;
	private static List<CourseData> cdArray;

	@BeforeAll
	public static void init() {
		// JM = new JSONManager();
		// cdArray = Arrays.asList(JM.LoadGenericJson(CourseData[].class,
		// "coursedata.json"));
		CSVManager<CourseData> csvm = new CSVManager<CourseData>("src/main/resources/coursedata.csv");
		cdArray = csvm.getList();

		System.out.println("Before all");
	}

	@Test
	void StudentQualBEMCABSCtest() {
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("StudentQualBEMCABSCtest");
		Predicate<CourseData> pd = (c -> (c.getDegree().equalsIgnoreCase("BE") || c.getDegree().equalsIgnoreCase("MCA")
				|| c.getDegree().equalsIgnoreCase("BSC")));

		cdArray.stream().filter(pd).forEach(System.out::println);
		assert (true);
	}

	@Test
	void StudentCountBEtest() {
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("StudentCountBEtest");
		Predicate<CourseData> pd = (c -> (c.getDegree().equalsIgnoreCase("BE")));

		long count = cdArray.stream().filter(pd).count();
		System.out.println("Count of BE Students is :" + count);
		assert (true);
	}
	
	@Test
	void StudentCountPlaced() {
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("StudentCountPlaced");
		Predicate<CourseData> pd = (c -> (c.getPlaced().equalsIgnoreCase("Y")));

		long count = cdArray.stream().filter(pd).count();
		System.out.println("Count of Number of Students Placed is :" + count);
		assert (true);
	}
	
	@Test
	void StudentCountCompletedButNotPlaced() {
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("StudentCountCompletedButNotPlaced");
		Predicate<CourseData> pd = (c -> (c.getCompleted().equalsIgnoreCase("Y") && !c.getPlaced().equalsIgnoreCase("Y")));

		long count = cdArray.stream().filter(pd).count();
		System.out.println("Count of Number of Students Who Completed Course But Not Placed is :" + count);
		assert (true);
	}
	
	@Test
	void StudentCountNotPlacedAndPlaced() {
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("StudentCountNotPlacedAndPlaced");
		Predicate<CourseData> pd = (c -> (c.getPlaced().equalsIgnoreCase("Y")));
		Predicate<CourseData> pd1 = (c -> (!c.getPlaced().equalsIgnoreCase("Y")));

		long count = cdArray.stream().filter(pd).count();
		System.out.println("Count of Number of Students Placed is :" + count);
		long count1 = cdArray.stream().filter(pd1).count();
		
		System.out.println("Count of Number of Students NOT Placed is :" + count1);
		assert (true);
	}
	
	@Test
	void StudentByName() {
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("StudentSearchByName" + "CLARK");
		Predicate<CourseData> pd = (c -> (c.getName().contains("CLARK") ));

		cdArray.stream().filter(pd).forEach(System.out::println);
		long count = cdArray.stream().filter(pd).count();
		System.out.println("Count of Number of Students Who Completed Course But Not Placed is :" + count);
		assert (true);
	}
	
	
	@Test
	void StudentNames() {
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("StudentNames" );
		
		for (CourseData ele : cdArray) {
			System.out.println(ele.getName());
		}
		
		assert (true);
	}
	
	@Test
	void StudentQualAndCount() {
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("StudentQualAndCount" );
		Map<String, Long> qualCount = new HashMap<String, Long>();
		qualCount = cdArray.stream().collect(Collectors.groupingBy(CourseData::getDegree, Collectors.counting()));
		System.out.println(qualCount);
		
		assert (true);
	}
	
	
	@Test
	void StudentQualAndScoreInRange() {
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("StudentQualAndScoreInRange" );
		int lower_range = 80;
		int higher_range = 90;
		
		Predicate<CourseData> pd = (c -> (c.getDegree().equalsIgnoreCase("BE") && c.getScore() >= lower_range && c.getScore() <= higher_range ));

		long count = cdArray.stream().filter(pd).count();
		System.out.println("Count of BE Students Who Scored Between 80 and 90 Percent Is :" + count + " out  of " + cdArray.stream().count());
		
			
		assert (true);
	}
}
