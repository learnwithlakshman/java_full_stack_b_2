package com.lwl.junit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class CSVManager<T> {

	private String filename;
	//private List<T> list = new ArrayList<T>();
	private List<CourseData> list = new ArrayList<CourseData>();
	
	public CSVManager(String filename) {
		this.filename = filename;
		T t = null;
		Scanner sc;
		try {
			sc = new Scanner(new File(filename));
			//sc.useDelimiter(",");
			sc.nextLine(); // to skip headers
			while (sc.hasNextLine()) {
				String string = sc.nextLine();
				String splitstr[] = string.split(",");
				/* need to make it generic ??
				 * if ( T.class == CourseData ) {
				 * 
				 * } t = new T (splitstr[0], splitstr[1],splitstr[2],splitstr[3],splitstr[4],
				 * Double.parseDouble(splitstr[5]));
				 */		
				CourseData cd = new CourseData(splitstr[0], splitstr[1], splitstr[2], splitstr[3], splitstr[4], Double.parseDouble(splitstr[5]));
				list.add(cd);
				
				}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getFilename() {
		return filename;
	}

	public List<CourseData> getList() {
		return list;
	}
	
	

	/*
	 * public static void main(String[] args) { CSVManager csvm = new
	 * CSVManager<CourseData>("src/main/resources/coursedata.csv"); }
	 */
}
