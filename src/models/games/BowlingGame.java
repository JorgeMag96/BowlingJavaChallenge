package models.games;

import java.util.List;
import java.util.Queue;

import models.Game;
import models.ScoreFrame;
import models.players.BowlingPlayer;

public class BowlingGame extends Game implements IBowling {

	public BowlingGame(List<BowlingPlayer> players) {
		super(players);
	}

	public List<ScoreFrame> getFrames(Queue<String> rolls) {
		 //TODO: Build the score frame.
		
		return null;
	}
	
}
