package com.lwl.iplserverapp.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Team {
		
		@Id
		private String label;
		private String city;
		private String home;
		private String coach;
		private String name;
		private List<Player> players;
		
		
		
	
}
