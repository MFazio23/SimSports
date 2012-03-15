package org.fazio.simsports.core.builders;

import org.fazio.simsports.core.types.*;

/**
 * @author Michael Fazio
 */
public class PlayerBuilder {

	protected String firstName;
	protected String lastName;
	protected String nickname;
	protected Position position;
	protected Attributes attributes;
	protected Ratings ratings;
	protected Statistics statistics;
	
	public PlayerBuilder setFirstName(final String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public PlayerBuilder setLastName(final String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public PlayerBuilder setNickname(final String nickname) {
		this.nickname = nickname;
		return this;
	}
	
	public PlayerBuilder setPosition(final Position position) {
		this.position = position;
		return this;
	}

	public PlayerBuilder setAttributes(final Attributes attributes) {
		this.attributes = attributes;
		return this;
	}

	public PlayerBuilder setRatings(final Ratings ratings) {
		this.ratings = ratings;
		return this;
	}

	public PlayerBuilder setStatistics(final Statistics statistics) {
		this.statistics = statistics;
		return this;
	}

	public Player build() {
		return new Player(
			this.attributes,
			this.firstName,
			this.lastName,
			this.nickname,
			this.position,
			this.ratings,
			this.statistics);
	}
}
