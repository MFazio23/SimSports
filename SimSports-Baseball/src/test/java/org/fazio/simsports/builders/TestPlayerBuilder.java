package org.fazio.simsports.builders;

import org.fazio.simsports.baseball.builders.BaseballPlayerBuilder;
import org.fazio.simsports.baseball.types.BaseballPlayer;
import org.fazio.simsports.core.builders.PlayerBuilder;
import org.fazio.simsports.core.types.Attributes;
import org.fazio.simsports.core.types.Position;
import org.fazio.simsports.core.types.Ratings;
import org.fazio.simsports.core.types.Statistics;
import org.mockito.Mockito;

/**
 * @author Michael Fazio
 */
public class TestPlayerBuilder extends BaseballPlayerBuilder {

	@Override
	public TestPlayerBuilder setFirstName(final String firstName) {
		this.firstName = "Test";
		return this;
	}

	@Override
	public PlayerBuilder setLastName(final String lastName) {
		this.lastName = "Player";
		return this;
	}

	@Override
	public PlayerBuilder setNickname(final String nickname) {
		this.nickname = "Testman";
		return this;
	}

	@Override
	public PlayerBuilder setPosition(final Position position) {
		this.position = Mockito.mock(Position.class);
		return this;
	}

	@Override
	public PlayerBuilder setAttributes(final Attributes attributes) {
		this.attributes = Mockito.mock(Attributes.class);
		return this;
	}

	@Override
	public PlayerBuilder setRatings(final Ratings ratings) {
		this.ratings = Mockito.mock(Ratings.class);
		return this;
	}

	@Override
	public PlayerBuilder setStatistics(final Statistics statistics) {
		this.statistics = Mockito.mock(Statistics.class);
		return this;
	}

	public BaseballPlayer build() {

		return new BaseballPlayer(
			this.attributes,
			this.firstName,
			this.lastName,
			this.nickname,
			this.position,
			this.ratings,
			this.statistics
		);
	}
}
