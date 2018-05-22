package com.org.hibernate.testProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.org.hibernate.model.MatchEvent;
import com.org.hibernate.model.Player;
import com.org.hibernate.model.Team;
import com.org.hibernate.util.HibernateUtil;

public class DataFecthingTest {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Match");
		List<MatchEvent> matches = new ArrayList<MatchEvent>();
		matches = query.getResultList();
		Iterator<MatchEvent> itr = matches.iterator();
		while(itr.hasNext()){
			MatchEvent m = itr.next();
			System.out.println(m.getMatchId() + m.getMatchName() + m.getMatchDuration());
			Set<Team> teams = m.getTeams();
			Iterator<Team> iterator = teams.iterator();
			while(iterator.hasNext()){
				Team t = iterator.next();
				System.out.println(t.getTeamId() + t.getTeamName() + t.getCountry());
				Set<Player> players = t.getPlayers();
				Iterator<Player> iterator2 = players.iterator();
				while(iterator2.hasNext()){
					Player p = iterator2.next();
					System.out.println(p.getPlayerId() + p.getPlayerName() + p.getAge());
				}
			}
		}
		tx.commit();
		session.close();
	}

}
