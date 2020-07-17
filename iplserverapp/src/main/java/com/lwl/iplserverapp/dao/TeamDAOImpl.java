package com.lwl.iplserverapp.dao;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.lwl.iplserverapp.dto.PlayerDTO;
import com.lwl.iplserverapp.dto.RoleCountDTO;
import com.lwl.iplserverapp.dto.TeamLabelDTO;

@Repository
public class TeamDAOImpl implements TeamDAO {
	private Logger log = LoggerFactory.getLogger(TeamDAOImpl.class);
	@Autowired
	private MongoOperations mongoOpe;

	@Override
	public TeamLabelDTO selectTeamLabels() {
		GroupOperation group = group().addToSet("_id").as("labels");
		ProjectionOperation project = project().and("labels").as("labels").andExclude("_id");
		Aggregation agg = Aggregation.newAggregation(group, project);
		AggregationResults<TeamLabelDTO> res = mongoOpe.aggregate(agg, "team", TeamLabelDTO.class);
		TeamLabelDTO obj = res.getUniqueMappedResult();
		return obj;
	}

	@Override
	public List<PlayerDTO> selectPlayersByTeam(String label) {
		MatchOperation match = match(Criteria.where("_id").is(label));
		UnwindOperation unwind = unwind("players");
		ProjectionOperation project = project().and("players.name").as("name").and("players.role").as("role")
				.and("players.price").as("price").and("_id").as("label").andExclude("_id");

		Aggregation aggQuery = Aggregation.newAggregation(match, unwind, project);
		AggregationResults<PlayerDTO> result = mongoOpe.aggregate(aggQuery, "team", PlayerDTO.class);
		List<PlayerDTO> players = result.getMappedResults();
		log.info("Total player found for team {} is {}", label, players.size());
		return players;
	}

	@Override
	public List<RoleCountDTO> selectRoleCountByTeam(String label) {
		MatchOperation match = match(Criteria.where("_id").is("CSK"));
		UnwindOperation unwind = unwind("players");
		GroupOperation group = group("players.role").count().as("count");
		ProjectionOperation project = project().and("_id").as("roleName").and("count").as("count").andExclude("_id");
		Aggregation agg = Aggregation.newAggregation(match, unwind, group, project);
		AggregationResults<RoleCountDTO> res = mongoOpe.aggregate(agg, "team", RoleCountDTO.class);
		List<RoleCountDTO> list = res.getMappedResults();
		log.info("Total roles found in DB:{}" , list.size());
		return list;
	}

	@Override
	public List<PlayerDTO> selectPlayerByTeamAndRole(String label, String role) {
		
		MatchOperation match1 = match(Criteria.where("_id").is(label));
		UnwindOperation unwind =  unwind("players");
		MatchOperation match2 = match(Criteria.where("players.role").is(role));
		ProjectionOperation project = project().and("players.name").as("name").and("players.role").as("role")
				.and("players.price").as("price").and("_id").as("label").andExclude("_id");

		Aggregation aggQuery = Aggregation.newAggregation(match1, unwind,match2, project);
		AggregationResults<PlayerDTO> result = mongoOpe.aggregate(aggQuery, "team", PlayerDTO.class);
		List<PlayerDTO> players = result.getMappedResults();
		log.info("Total player found for team {} and for role: {} is {}", label, role, players.size());
		return players;
		
	}

}
