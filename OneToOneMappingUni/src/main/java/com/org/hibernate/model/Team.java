package com.org.hibernate.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {
	
	@Id
	@Column(name = "team_id")
	private int teamId;
	
	@Column(name = "team_name")
	private String teamName;
	
	@Column(name = "country")
	private String country;
	
	@OneToMany(mappedBy="team", cascade= CascadeType.ALL)
	private Set<Player> players;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "match_id", nullable = false)
	private MatchEvent matchEvent;
	
	public Team() {
		super();
	}
	
	public Team(int teamId, String teamName, String country, Set<Player> players, MatchEvent matchEvent) {
		this.teamId = teamId;
		this.teamName = teamName;
		this.country = country;
		this.players = players;
		this.matchEvent = matchEvent;
	}



	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	public MatchEvent getMatch() {
		return matchEvent;
	}

	public void setMatch(MatchEvent matchEvent) {
		this.matchEvent = matchEvent;
	}
	

}
