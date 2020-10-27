package models.games.bowling;

import java.util.ArrayList;
import java.util.List;

import models.games.BowlingGame;

public class Frame {
	
	public Frame() {
		this.remainingPins = 10;
		this.score = 0;
		this.pinfalls = new ArrayList<>();
	}
	
	public void registerRoll(String roll) {
		
		if(roll.equals(BowlingGame.FOUL)) {
			// Pins don't change.
		}
		else if(roll.equals(BowlingGame.SPARE) || 
				roll.equals(BowlingGame.STRIKE)) {
			remainingPins = 0;
		}
		else {
			remainingPins -= Integer.parseInt(roll);
		}
		
		pinfalls.add(roll);
	}
	
	public int getRemainingPins() {
		return remainingPins;
	}
	
	public void resetPins() {
		remainingPins = 10;
	}
	
	public List<String> getPinfalls(){
		return this.pinfalls;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "ScoreFrame [pinfalls=" + pinfalls +"]";
	}

	private int remainingPins;
	private int score;
	private List<String> pinfalls;
	
}
