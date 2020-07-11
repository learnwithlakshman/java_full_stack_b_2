package com.lwl.springapp.cbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.cj.pj.Printer;
import com.ljava.cbook.service.ContactService;

@Component
public class CbookController {
		
		
		private final ContactService service;
		private final Printer printer;
		
		@Autowired
		public CbookController(ContactService service, Printer printer) {
			super();
			this.service = service;
			this.printer = printer;
		}

		public static void main(String[] args) {
			
			ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
			CbookController obj = context.getBean(CbookController.class);
			System.out.println(context.getBean(ContactService.class));
			System.out.println(context.getBean(ContactService.class));
			System.out.println(context.getBean(ContactService.class));
			
		}
		
		private void addContact() {
			System.out.println(service);
			System.out.println(printer);
			
		}
		public void viewContacts() {
			
		}
}
