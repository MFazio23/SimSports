package org.fazio.simsports.core.types;

/**
 * @author Michael Fazio
 */
public class Player {
	
	protected final String firstName;
	protected final String lastName;
	protected final String nickname;
	protected final Position position;
	protected final Attributes attributes;
	protected final Ratings ratings;
	protected final Statistics statistics;

	public Player(Attributes attributes, String firstName, String lastName, String nickname, Position position, Ratings ratings, Statistics statistics) {
		this.attributes = attributes;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.position = position;
		this.ratings = ratings;
		this.statistics = statistics;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNickname() {
		return nickname;
	}

	public Position getPosition() {
		return position;
	}

	public Ratings getRatings() {
		return ratings;
	}

	public Statistics getStatistics() {
		return statistics;
	}
}
