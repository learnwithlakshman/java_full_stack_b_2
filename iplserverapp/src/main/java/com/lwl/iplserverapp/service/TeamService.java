package com.lwl.iplserverapp.service;

import java.util.List;

import com.lwl.iplserverapp.domain.Team;
import com.lwl.iplserverapp.dto.PlayerDTO;
import com.lwl.iplserverapp.dto.RoleCountDTO;
import com.lwl.iplserverapp.dto.TeamLabelDTO;

public interface TeamService {
	
			public Team addTeam(Team team);
			public List<Team> getTeams();
			public List<Team> search(String str);
			public boolean removeTeam(String label);
			public Team updateTeam(Team team);
			public Team getTeam(String label);
			
			public TeamLabelDTO getTeamLabels();
			public List<PlayerDTO> getPlayersByTeam(String label);
			public List<RoleCountDTO> getRoleCountByTeam(String label);
			public List<PlayerDTO> getPlayerByTeamAndRole(String label,String role);
}
