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
	
	public int getFinalScore() {
		return this.finalScore;
	}
	
	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}
	
	private Queue<String> rolls;
	private int finalScore = 0;
}
