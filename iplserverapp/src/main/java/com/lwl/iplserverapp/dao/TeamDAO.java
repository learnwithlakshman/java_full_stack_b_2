package com.lwl.iplserverapp.dao;

import java.util.List;

import com.lwl.iplserverapp.dto.PlayerDTO;
import com.lwl.iplserverapp.dto.RoleCountDTO;
import com.lwl.iplserverapp.dto.TeamLabelDTO;

public interface TeamDAO {
	
	public TeamLabelDTO getTeamLabels();
	public List<PlayerDTO> getPlayersByTeam(String label);
	public List<RoleCountDTO> getRoleCountByTeam(String label);
	public List<PlayerDTO> getPlayerByTeamAndRole(String label,String role);
	
}
