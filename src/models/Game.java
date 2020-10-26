package models;

import java.util.List;

public abstract class Game{
	
	public Game(List<? extends Player> players) {
		this.players = players;
	}
	
	public List<? extends Player> getPlayers(){
		return this.players;
	}

	protected List<? extends Player> players;
	
	public static final String BOWLING = "bowling";
}
