package models;

import java.util.List;

public class ScoreFrame {
	
	public ScoreFrame(boolean isFinalFrame) {
		this.isFinalFrame = isFinalFrame;
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
	
	public boolean registerRoll(String roll) throws Exception {
		
		if(pinfalls.size() > 1 || !isFinalFrame) {
			throw new Exception("");
		}
		else {
			
		}
		//TODO: Logic to register a roll in the current frame.
		
		return false;
	}
	
	private boolean isFinalFrame;
	private List<String> pinfalls;
	private int score;
}
