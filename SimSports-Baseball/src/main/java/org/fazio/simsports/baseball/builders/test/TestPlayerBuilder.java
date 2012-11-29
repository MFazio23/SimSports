package org.fazio.simsports.baseball.builders.test;

import org.fazio.simsports.baseball.builders.BaseballPlayerBuilder;
import org.fazio.simsports.baseball.types.BaseballPlayer;
import org.fazio.simsports.core.types.Attributes;
import org.fazio.simsports.core.types.Position;
import org.fazio.simsports.core.types.Ratings;
import org.fazio.simsports.core.types.Statistics;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

/**
 * @author Michael Fazio
 */
public class TestPlayerBuilder extends BaseballPlayerBuilder {

	@Mock
	private List<Position> mockPositionList;

	public TestPlayerBuilder() {
		this.setUpTestPlayer();
	}

	protected void setUpTestPlayer() {
		this.firstName = "Test";
		this.lastName = "Player";
		this.nickname = "Testington";
		this.primaryPosition = Mockito.mock(Position.class);
		this.positions = this.mockPositionList;
		this.attributes = Mockito.mock(Attributes.class);
		this.ratings = Mockito.mock(Ratings.class);
		this.statistics = Mockito.mock(Statistics.class);
	}

	public BaseballPlayer build() {

		return new BaseballPlayer(
			this.attributes,
			this.firstName,
			this.lastName,
			this.nickname,
			this.number,
			this.primaryPosition,
			this.positions,
			this.statistics
		);
	}
}
