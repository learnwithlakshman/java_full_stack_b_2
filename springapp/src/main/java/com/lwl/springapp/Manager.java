package com.lwl.springapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.lwl.springapp")
public class Manager {

	public static void main(String[] args) {
		
		/*
		 * Greetings obj = new BirthdayGreetings();
		 * obj.setMessage("Many many happy return of the day"); obj.sendMessage();
		 */
//		ApplicationContext context = new ClassPathXmlApplicationContext("greetings.xml");
//		
//		Greetings obj1 = context.getBean(Greetings.class);
//		Greetings obj2 = context.getBean(Greetings.class);
//		Greetings obj3 = context.getBean(Greetings.class);
//		System.out.println(obj1);
//		System.out.println(obj2);
//		System.out.println(obj3);
		
		
		 ApplicationContext context = new AnnotationConfigApplicationContext(Manager.class);
		 String[] names = context.getBeanDefinitionNames();
		 for(String name:names) {
			 System.out.println(name);
		 }
	}
	
	
}
