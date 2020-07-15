package com.lwl.iplserverapp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.lwl.iplserverapp.domain.Team;
import com.lwl.iplserverapp.repo.TeamRepo;
import com.lwl.iplserverapp.service.exception.TeamNotFoundException;

@Service
public class TeamServiceImpl implements TeamService {

	private Logger log = LoggerFactory.getLogger(TeamServiceImpl.class);

	private String labelNotFoundMessage = "Team with given label : %s is not found";

	@Autowired
	private TeamRepo teamRepo;

	@Override
	public Team addTeam(Team team) {
		Assert.notNull(team, "Team can't be null");
		Assert.notNull(team.getLabel(), "Team label can't be null or empty");
		Team savedTeam = teamRepo.save(team);
		log.info("Team with label : {} is added successfully", savedTeam.getLabel());
		return savedTeam;
	}

	@Override
	public List<Team> getTeams() {
		List<Team> list = teamRepo.findAll();
		log.info("Total {} teams found", list.size());
		return teamRepo.findAll();
	}

	@Override
	public List<Team> search(String str) {
		List<Team> list = teamRepo.findByNameLike(str);
		log.info("Total team foud for search string {} is {}", str, list.size());
		return list;
	}

	@Override
	public boolean removeTeam(String label) {

		Assert.notNull(label, "Team label can't be null or empty");
		if (teamRepo.findById(label).isPresent()) {
			teamRepo.deleteById(label);
			log.info("Team :{} details deleted successfully", label);
			return true;
		} else {
			log.info("Team : {} is not found, so it couldn't be updated", label);
			throw new TeamNotFoundException(String.format(labelNotFoundMessage, label));
		}
	}
	

	@Override
	public Team updateTeam(Team team) {
		Assert.notNull(team, "Team can't be null");
		Assert.notNull(team.getLabel(), "Team label can't be null or empty");
		if (teamRepo.findById(team.getLabel()).isPresent()) {
			team = teamRepo.save(team);
			log.info("Team {} details updated successfully", team.getLabel());
		} else {
			log.info("Team {} is not found, so it couldn't be updated", team.getLabel());
			throw new TeamNotFoundException(String.format(labelNotFoundMessage, team.getLabel()));
		}
		return team;
	}

	@Override
	public Team getTeam(String label) {
		Assert.notNull(label, "Search label can't be emtpy or null");
		Optional<Team> optTeam = teamRepo.findById(label);
		return optTeam.orElseThrow(() -> new TeamNotFoundException(String.format(labelNotFoundMessage, label)));
	}

}
