package com.lwl.iplserverapp.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwl.iplserverapp.domain.Team;

import lombok.Getter;

@Getter
@Configuration
public class AppSeedDataService {

		private List<Team> teamList;
		
		@PostConstruct
		public void init() {
			ObjectMapper mapper = new ObjectMapper();
		    try {
		    	teamList = mapper.readValue(this.getClass().getResourceAsStream("/ipl2020.json"), new TypeReference<List<Team>>() {});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
}
