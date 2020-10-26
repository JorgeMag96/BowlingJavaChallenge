package models;

import java.util.List;

import utils.ScorePrinter;

public abstract class Game implements ScorePrinter{
	
	public Game(List<? extends Player> players) {
		this.players = players;
	}
	
	public List<? extends Player> getPlayers(){
		return this.players;
	}

	protected List<? extends Player> players;
	
}
