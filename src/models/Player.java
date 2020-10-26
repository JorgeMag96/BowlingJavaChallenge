package models;

public abstract class Player{

	public Player (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	protected String name;
	
}
