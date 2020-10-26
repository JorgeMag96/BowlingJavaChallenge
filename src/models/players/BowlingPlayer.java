package models.players;

import java.util.LinkedList;
import java.util.Queue;

import models.Player;

public class BowlingPlayer extends Player{

	public BowlingPlayer(String name) {
		super(name);
		this.rolls = new LinkedList<String>();
	}
	
	public BowlingPlayer(String name, Queue<String> rolls){
		super(name);
		this.rolls = rolls;
	}
	
	public Queue<String> getRolls(){
		return this.rolls;
	}
	
	public boolean addRoll(String roll) {
		return this.rolls.add(roll);
	}
	
	
	private Queue<String> rolls;
}
