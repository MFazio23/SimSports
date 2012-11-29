package org.fazio.simsports.baseball.builders;

import org.fazio.simsports.baseball.types.BaseballPlayer;
import org.fazio.simsports.core.builders.PlayerBuilder;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/15/12 9:58 AM
 */
public class BaseballPlayerBuilder extends PlayerBuilder {

	public BaseballPlayer build() {
		return new BaseballPlayer(
			this.attributes,
			this.firstName,
			this.lastName,
			this.nickname,
			this.number,
			this.primaryPosition,
			this.positions,
			this.statistics);
	}

}
