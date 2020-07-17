package com.lwl.iplserverapp.web;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwl.iplserverapp.domain.Team;
import com.lwl.iplserverapp.dto.PlayerDTO;
import com.lwl.iplserverapp.dto.RoleCountDTO;
import com.lwl.iplserverapp.dto.TeamLabelDTO;
import com.lwl.iplserverapp.service.TeamService;

@RestController
@RequestMapping("/api/v1/ipl")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@PostMapping("/addteam")
	public Team addTeam(@RequestBody Team team) {
		return teamService.addTeam(team);
	}

	@GetMapping("/allteams")
	public List<Team> allTeams() {
		return teamService.getTeams();
	}

	@GetMapping("/search")
	public List<Team> search(@RequestParam String str) {
		return teamService.search(str);
	}

	@PutMapping("/modify")
	public Team updateTeam(@RequestBody Team team) {
		return teamService.updateTeam(team);
	}

	@DeleteMapping("/remove/{label}")
	public boolean removeTeam(@PathVariable("label") String label) {
		return teamService.removeTeam(label);
	}

	@GetMapping("/team/{label}")
	public Team fetchTeam(@PathVariable("label") String label) {
		return teamService.getTeam(label);
	}

	@GetMapping("/team/labels")
	public TeamLabelDTO fetchTeamLabels() {
		return teamService.getTeamLabels();
	}

	@GetMapping("/team/players/{label}")
	public List<PlayerDTO> fetchPlayerByTeam(@PathVariable("label") String label) {
		return teamService.getPlayersByTeam(label);
	}

	@GetMapping("/team/players/{label}/{role}")
	public List<PlayerDTO> fetchPlayerByTeamAndRole(@PathVariable("label") String label,
			@PathVariable("role") String role) {
		return teamService.getPlayerByTeamAndRole(label, role);
	}

	@GetMapping("/team/rolecount/{label}")
	public List<RoleCountDTO> fetchRoleCountByTeam(@PathVariable("label") String teamLabel) {
		return teamService.getRoleCountByTeam(teamLabel);
	}

}
