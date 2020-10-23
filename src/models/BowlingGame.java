package models;

import java.util.List;

public abstract class BowlingGame {
	
	public BowlingGame(List<Player> players) {
		this.players = players;
	}

	protected List<Player> players;
	
	// Bowling game constants.
	public static final String FOUL = "F";
	public static final String SPARE = "/";
	public static final String STRIKE = "X";
}
