package org.fazio.simsports.core.builders;

import org.fazio.simsports.core.types.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Fazio
 */
public abstract class PlayerBuilder {

	protected String firstName;
	protected String lastName;
	protected String nickname;
	protected String number;
	protected Position primaryPosition;
	protected List<Position> positions;
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

	public PlayerBuilder setNumber(final String number) {
		this.number = number;
		return this;
	}

	public PlayerBuilder setPrimaryPosition(final Position primaryPosition) {
		this.primaryPosition = primaryPosition;
		if(this.positions == null) this.positions = new ArrayList<Position>();
		this.positions.add(primaryPosition);
		return this;
	}

	public PlayerBuilder setPositions(final List<Position> positions) {
		this.positions = positions;
		return this;
	}

	public PlayerBuilder addPosition(final Position positions) {
		if(this.positions == null) this.positions = new ArrayList<Position>();
		this.positions.add(positions);
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

	public abstract Player build();
}
