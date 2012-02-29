package org.fazio.simsports.core.builders;

import org.fazio.simsports.core.types.Position;

/**
 * @author Michael Fazio
 */
public class PlayerBuilder {

	private String firstName;
	private String lastName;
	private String nickname;
	private Position position;
	
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
}
