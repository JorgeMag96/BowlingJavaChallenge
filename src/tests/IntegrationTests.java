package tests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import models.games.BowlingGame;
import models.players.BowlingPlayer;

public class IntegrationTests {

	@Test
	public void perfectScore() {
		
		BowlingPlayer testPlayer = new BowlingPlayer("TestPlayer");
		while(testPlayer.getRolls().size() < 12) {
			testPlayer.addRoll("10");
		}
		
		List<BowlingPlayer> players = new ArrayList<>();
		players.add(testPlayer);
		
		new BowlingGame(players);
		
		assertEquals(300, players.get(0).getFinalScore());
		
	}
	
	@Test
	public void zeroScore() {
		BowlingPlayer testPlayer = new BowlingPlayer("TestPlayer");
		while(testPlayer.getRolls().size() < 12) {
			testPlayer.addRoll("0");
		}
		
		List<BowlingPlayer> players = new ArrayList<>();
		players.add(testPlayer);
		
		new BowlingGame(players);
		
		assertEquals(0, players.get(0).getFinalScore());
	}

}
