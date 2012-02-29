package org.fazio.simsports.core.types;

/**
 * @author Michael Fazio
 */
public class Player {
	
	private final String firstName;
	private final String lastName;
	private final String nickname;
	private final Position position;

	public Player(final Position position, final String nickname, final String firstName, final String lastName) {
		this.position = position;
		this.nickname = nickname;
		this.firstName = firstName;
		this.lastName = lastName;
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
}
