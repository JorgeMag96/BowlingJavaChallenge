import java.io.File;

import models.Game;
import models.games.BowlingGame;
import utils.BowlingRollsParser;
import utils.ScorePrinter;

public class Play {

	public static void main(String[] args) {

		// Example: play bowling test1
		String gameName = args[0];
		File gameData = new File(args[1]);

		if (!gameData.exists()) {
			System.out.println(gameData.getAbsolutePath() + " not found.");
			return;
		}

		try {
			
			Game game;
			
			if (gameName.equalsIgnoreCase(Game.BOWLING)) {
				
				game = new BowlingGame(BowlingRollsParser.parseRolls(gameData));
				ScorePrinter.printResults();
			}
			else {
				throw new Exception("Please enter a valid game name.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
