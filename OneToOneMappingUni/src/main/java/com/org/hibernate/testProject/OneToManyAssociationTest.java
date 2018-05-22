package com.org.hibernate.testProject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.org.hibernate.model.MatchEvent;
import com.org.hibernate.model.Player;
import com.org.hibernate.model.Team;
import com.org.hibernate.util.HibernateUtil;

public class OneToManyAssociationTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		MatchEvent match1 = new MatchEvent();
		match1.setMatchId(1);
		match1.setMatchName("Indian Primiur Leag");
		match1.setMatchDuration("8 hours");
		
		Set<Team> teams = new HashSet<Team>();
		Team team1 = new Team();
		team1.setTeamId(1001);
		team1.setTeamName("Indian cricket team");
		team1.setCountry("India");
		team1.setMatch(match1);
		teams.add(team1);
		
		match1.setTeams(teams);
		
		Player player1 = new Player();
		player1.setPlayerId(111);
		player1.setPlayerName("Sachin Tendulkar");
		player1.setAge("38");
		player1.setTeam(team1);
		
		Player player2 = new Player();
		player2.setPlayerId(112);
		player2.setPlayerName("Mahendra Singh Dhoni");
		player2.setAge("32");
		player2.setTeam(team1);
		
		Player player3 = new Player();
		player3.setPlayerId(113);
		player3.setPlayerName("Shikhar Dhawan");
		player3.setAge("26");
		player3.setTeam(team1);
		
		Set<Player> players = new HashSet<Player>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		
		team1.setPlayers(players);
		
		Transaction tx =  session.beginTransaction();

		session.save(match1);
		
		// what happen if we does not save child ?
		// will hibernate saves all the child while saving parent class only ? 
		// what type of configuration we need to do so that ?
		// Answer : cascadetype se faisla hoga ki child save ho rha ya nahi
		//session.save(team1);
		//session.save(player1);
		//session.save(player2);
		//session.save(player3);
		
		/*Set<Player> team1Players = team1.getPlayers();
		Iterator<Player> itr = team1Players.iterator();
		while(itr.hasNext()){
			Player p  = itr.next();
			System.out.println(p.getPlayerId() + "---" + p.getPlayerName() + "-----" + p.getAge()+ "---" + p.getTeam().getTeamId());
		}*/
		
		tx.commit();
		session.close();

	}

}
