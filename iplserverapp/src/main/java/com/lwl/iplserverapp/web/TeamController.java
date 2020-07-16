package com.lwl.iplserverapp.web;

import java.util.List;
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
	
	
	

}
