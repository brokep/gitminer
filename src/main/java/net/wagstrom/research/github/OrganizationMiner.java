package net.wagstrom.research.github;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.api.v2.schema.Organization;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.Team;
import com.github.api.v2.schema.User;
import com.github.api.v2.services.OrganizationService;

public class OrganizationMiner {
	private OrganizationService service = null;
	private Logger log;
	
	public OrganizationMiner(OrganizationService service) {
		this.service = service;
		log = LoggerFactory.getLogger(this.getClass());
	}
	
	public Organization getOrganizationInformation(String organization) {
		Organization org = service.getOrganization(organization);
		log.debug("Fetched organization: {}", organization);
		return org;
	}
	
	public List<User> getOrganizationOwners(String organization) {
		List<User> owners = service.getOwners(organization);
		log.debug("Fetched owners for organization: {} number: {}", organization, owners.size());
		return owners;
	}
	
	public List<User> getOrganizationPublicMembers(String organization) {
		List<User> members = service.getPublicMembers(organization);
		log.debug("Fetched public members for organization: {} number: {}", organization, members.size());
		return members;
	}
	
	public List<Repository> getOrganizationPublicRepositories(String organization) {
		List<Repository> repos = service.getPublicRepositories(organization);
		log.debug("Fetched public repositories for organization: {} number: {}", organization, repos.size());
		return repos;
	}
	
	public List<Team> getOrganizationTeams(String organization) {
		List<Team> teams = service.getTeams(organization);
		log.debug("Fetched teams for organization: {} number: {}", organization, teams.size());
		return teams;
	}
	
	public List<User> getOrganizationTeamMembers(String teamId) {
		List<User> users = service.getTeamMembers(teamId);
		log.debug("Fetched organization team members for team: {} number: {}", teamId, users.size());
		return users;
	}
	
	public List<Repository> getOrganizationTeamRepositories(String teamId) {
		List<Repository> repos = service.getTeamRepositories(teamId);
		log.debug("Fetched organization repositories for team: {} number: {}", teamId, repos.size());
		return repos;
	}
}