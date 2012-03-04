package org.fazio.simsports.core.types;

/**
 * @author Michael Fazio
 */
public class Player {
	
	private final String firstName;
	private final String lastName;
	private final String nickname;
	private final Position position;
	private final Attributes attributes;
	private final Ratings ratings;
	private final Statistics statistics;

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
