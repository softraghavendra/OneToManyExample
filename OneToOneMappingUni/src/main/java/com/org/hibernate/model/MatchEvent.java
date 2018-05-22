package com.org.hibernate.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "match_event")
public class MatchEvent {
	
	@Id
	@Column(name = "match_id")
	private int matchId;
	
	@Column(name= "match_name")
	private String matchName;
	
	@Column(name = "match_duration")
	private String matchDuration;
	
	@OneToMany(mappedBy="matchEvent", cascade= CascadeType.ALL)
	private Set<Team> teams;

	public MatchEvent() {
		super();
	}

	public MatchEvent(int matchId, String matchName, String matchDuration, Set<Team> teams) {
		super();
		this.matchId = matchId;
		this.matchName = matchName;
		this.matchDuration = matchDuration;
		this.teams = teams;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public String getMatchDuration() {
		return matchDuration;
	}

	public void setMatchDuration(String matchDuration) {
		this.matchDuration = matchDuration;
	}

	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}
	
	
	

}
