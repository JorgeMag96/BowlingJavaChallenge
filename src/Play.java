
import java.io.File;

import models.Game;
import models.games.BowlingGame;
import models.players.BowlingPlayer;
import utils.DataParser;
import utils.GameTypes;
import utils.bowling.BowlingRollsParser;

public class Play {

	public static void main(String[] args) {

		// Example: play bowling test1
		String gameType = args[0];
		File gameData = new File(args[1]);

		if (!gameData.exists()) {
			System.out.println(gameData.getAbsolutePath() + " not found.");
			return;
		}

		try {
			
			Game game;
			
			if (gameType.equalsIgnoreCase(GameTypes.BOWLING.toString())) {
				
				DataParser<BowlingPlayer> dataParser = new BowlingRollsParser();
				game = new BowlingGame(dataParser.execute(gameData));
			}
			else {
				throw new Exception("Please enter a valid game name.");
			}
			
			game.printResults();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
