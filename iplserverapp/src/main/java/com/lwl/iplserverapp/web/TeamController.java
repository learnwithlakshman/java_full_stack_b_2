package com.lwl.iplserverapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwl.iplserverapp.domain.Team;
import com.lwl.iplserverapp.service.TeamService;

@RestController
@RequestMapping("/api/v1/ipl")
public class TeamController {

	private TeamService teamService;

	@Autowired
	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}

	@PostMapping("/addteam")
	public Team addTeam(@RequestBody Team team) {
		return teamService.addTeam(team);
	}

	@GetMapping("/allteams")
	public List<Team> allTeams() {
		return teamService.getTeams();
	}
}
