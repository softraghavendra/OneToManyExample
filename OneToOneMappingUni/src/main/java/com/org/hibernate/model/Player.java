package com.org.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {

	@Id
	@Column(name = "player_id")
	private int playerId;
	
	@Column(name = "player_name")
	private String PlayerName;
	
	@Column(name = "age")
	private String age;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id", nullable = false)
	private Team team;
	
	public Player() {
		super();
	}

	public Player(int playerId, String playerName, String age, Team team) {
		super();
		this.playerId = playerId;
		PlayerName = playerName;
		this.age = age;
		this.team = team;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

		
}
