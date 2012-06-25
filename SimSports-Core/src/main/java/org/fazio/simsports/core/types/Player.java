package org.fazio.simsports.core.types;

/**
 * @author Michael Fazio
 */
public class Player {
	
	protected final String firstName;
	protected final String lastName;
	protected final String nickname;
	protected final Team team;
	protected final Position position;
	protected final Attributes attributes;
	protected final Ratings ratings;
	protected final Statistics statistics;

	public Player(Attributes attributes, String firstName, String lastName, String nickname, Team team, Position position, Ratings ratings, Statistics statistics) {
		this.attributes = attributes;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.team = team;
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

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getNickname() {
		return nickname;
	}

	public String getFullNamePlusNickname() {
		return firstName + " \"" + nickname + "\" " + lastName;
	}

	public Team getTeam() {
		return team;
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

	@Override
	public String toString() {
		return new StringBuilder()
			.append(this.firstName)
			.append(" ")
			.append(this.lastName)
			.append(" (")
			.append(this.team.getMainShortName())
			.append(" - ")
			.append(this.position)
			.append(")")
			.toString();
	}
}
