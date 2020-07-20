package com.lwl.quizer.service;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	
	@Autowired
	private QuestionService questionService;

	
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);


	@Scheduled(cron = "${cornexp}" )
	public void reportCurrentTime() {
		LocalTime time = LocalTime.now();
		log.info("The time is now {}",time);
		log.info("{} - {}",LocalTime.now().getSecond() ,questionService.isPalindrome(LocalTime.now().getSecond()));
	}
		
}
