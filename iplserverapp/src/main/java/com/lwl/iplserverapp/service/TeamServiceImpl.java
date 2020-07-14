package com.lwl.iplserverapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwl.iplserverapp.domain.Team;

@Service
public class TeamServiceImpl implements TeamService {
	
	private Logger log = LoggerFactory.getLogger(TeamServiceImpl.class);
	private AppSeedDataService appDataService;

	

	@Autowired
	public TeamServiceImpl(AppSeedDataService appDataService) {
		this.appDataService = appDataService;
		
	}

	@Override
	public Team addTeam(Team team) {
		return null;
	}

	@Override
	public List<Team> getTeams() {
		List<Team> teams = this.appDataService.getTeamList();
		log.info("Total {} teams found",teams.size());
		return teams;
	}

}
