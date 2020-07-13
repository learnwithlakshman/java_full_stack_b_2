package com.lwl.iplserverapp.service.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lwl.iplserverapp.domain.Team;
import com.lwl.iplserverapp.service.TeamService;

@SpringBootTest
public class TeamServiceTest {
		
		@Autowired
		private TeamService teamService;
		
		@Test
		public void initialTeamsInfo() {
			List<Team> list = teamService.getTeams();
			assertThat(list).hasSize(2);
		}
		@Test
		public void addTeam() {
			Team team = new Team("KKR");
			Team savedTeam = teamService.addTeam(team);
			assertThat(savedTeam.getId()).isNotNull();
			assertThat(team.getName()).equals(savedTeam.getName());
		}
}
