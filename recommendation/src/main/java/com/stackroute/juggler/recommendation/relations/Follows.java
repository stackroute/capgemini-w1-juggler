package com.stackroute.juggler.recommendation.relations;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.stackroute.juggler.recommendation.domain.Genre;
import com.stackroute.juggler.recommendation.domain.User;

@RelationshipEntity(type = "follows")
public class Follows {
	@StartNode
	private User user;
	@EndNode
	private Genre genre;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Follows(User user, Genre genre) {
		super();
		this.user = user;
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "follows [user=" + user + ", genre=" + genre + "]";
	}

}
