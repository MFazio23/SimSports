package org.fazio.simsports.core.types;

import java.util.List;

/**
 * @author Michael Fazio
 */
public abstract class Player {
	
	protected final String firstName;
	protected final String lastName;
	protected final String nickname;
	protected final String number;
	protected final List<Position> positions;
	protected final Attributes attributes;
	protected final Ratings ratings;
	protected final Statistics statistics;

	public Player(
		final Attributes attributes,
		final String firstName,
		final String lastName,
		final String nickname,
		final String number,
		final List<Position> positions,
		final Statistics statistics) {
			this.attributes = attributes;
			this.firstName = firstName;
			this.lastName = lastName;
			this.nickname = nickname;
			this.number = number;
			this.positions = positions;
			this.ratings = this.calculateRatings();
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

	public String getNumber() {
		return number;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public abstract Ratings calculateRatings();

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
			.append(this.positions.get(0))
			.append(")")
			.toString();
	}
}
