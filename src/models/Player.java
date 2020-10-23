package models;

import java.util.ArrayList;
import java.util.List;

public class Player {

	public Player (String name) {
		this(name, new ArrayList<String>());
	}
	
	public Player(String name, List<String> rolls){
		this.name = name;
		this.rolls = rolls;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<String> getRolls(){
		return this.rolls;
	}
	
	public boolean addRoll(String roll) {
		//TODO: Is this player able to do the roll ?
		return this.rolls.add(roll);
	}
	
	private String name;
	private List<String> rolls;
	
}
