package com.lwl.iplserverapp.dao;

import java.util.List;

import com.lwl.iplserverapp.dto.PlayerDTO;
import com.lwl.iplserverapp.dto.RoleCountDTO;
import com.lwl.iplserverapp.dto.TeamLabelDTO;

public interface TeamDAO {
	
	public TeamLabelDTO selectTeamLabels();
	public List<PlayerDTO> selectPlayersByTeam(String label);
	public List<RoleCountDTO> selectRoleCountByTeam(String label);
	public List<PlayerDTO> selectPlayerByTeamAndRole(String label,String role);
	
}
