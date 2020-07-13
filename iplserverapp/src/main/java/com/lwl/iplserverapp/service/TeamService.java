package com.lwl.iplserverapp.service;

import java.util.List;

import com.lwl.iplserverapp.domain.Team;

public interface TeamService {
	
			public Team addTeam(Team team);
			public List<Team> getTeams();
}
