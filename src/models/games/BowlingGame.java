package models.games;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

import models.Game;
import models.games.bowling.ScoreFrame;
import models.players.BowlingPlayer;

public class BowlingGame extends Game {

	public BowlingGame(List<BowlingPlayer> players) {
		super(players);
		results = new HashMap<>();
		players.forEach(p -> buildScoreFrames(p.getRolls()));
	}

	private void buildScoreFrames(Queue<String> rolls) {
		 //TODO: Build the score frame.
		
		
		
	}

	@Override
	public void printResults() {
		players.forEach(p -> results.put((BowlingPlayer)p, new ArrayList<ScoreFrame>()));
		System.out.println("Frame\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10");
		
		results.forEach((player, frames) ->{
			System.out.println(player.getName());
			frames.forEach(System.out::print);
		});
		
	}
	
	private HashMap<BowlingPlayer, List<ScoreFrame>> results;
	
	// Game constants.
	public static final int FRAMES = 10;
	public static final String FOUL = "F";
	public static final String SPARE = "/";
	public static final String STRIKE = "X";
}
