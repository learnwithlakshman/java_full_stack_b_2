package com.lwl.iplserverapp.service.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lwl.iplserverapp.domain.Team;
import com.lwl.iplserverapp.service.TeamService;

@SpringBootTest
class TeamServiceTest {

	@Autowired
	private TeamService teamService;

	@Test
	void initialTeamsInfo() {
	
	}

	@Test
	void addTeam() {
	
	}
}
