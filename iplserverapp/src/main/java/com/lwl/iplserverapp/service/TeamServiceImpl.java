package com.lwl.iplserverapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.lwl.iplserverapp.domain.Team;


public class TeamServiceImpl implements TeamService {

	private Map<String, Team> map = new HashMap<>();

	public TeamServiceImpl() {
		String uuid = UUID.randomUUID().toString();
		Team team = Team.builder().id(uuid).name("CSK").build();
		map.put(uuid, team);
		uuid = UUID.randomUUID().toString();
		team = Team.builder().id(uuid).name("RCB").build();
		map.put(uuid, team);
	}

	@Override
	public Team addTeam(Team team) {
		String uuid = UUID.randomUUID().toString();
		team.setId(uuid);
		map.put(uuid, team);
		return team;
	}

	@Override
	public List<Team> getTeams() {
		ArrayList<Team> list = new ArrayList<>();
		list.addAll(map.values());
		return list;
	}

}
