package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import models.Game;
import models.Player;
import models.games.IBowling;
import models.players.BowlingPlayer;

public class BowlingRollsParser {

	/**
	 * Parse the given text file into a list of players.<br><br>
	 * 
	 * Text file should use the following format:<br><br>
	 * [player name] [roll]<br>
	 * [player name] [roll]<br>
	 * [...........] [....]
	 * 
	 * @param file
	 * @return List of Player objects
	 * @throws Exception - In case of a parse exception.
	 */
	public static List<BowlingPlayer> parseRolls(File file) throws Exception {

		try {
			HashMap<String, BowlingPlayer> players = new HashMap<>();
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {

				String[] data = sc.nextLine().split(" ");
				
				// Skip in case of a wrong formatted line, or just a blank.
				if(data.length != 2) {
					continue;
				}
				
				String playerName = data[0];

				String roll = data[1];

				if (players.containsKey(playerName)) {
					if (validRoll(roll)) {
						players.get(playerName).addRoll(roll);
					}
				} else {
					players.put(playerName, new BowlingPlayer(playerName));
					players.get(playerName).addRoll(roll);
				}
			}
			sc.close();

			// TODO: Remove this code when finish.
			players.forEach((k, p) -> {
				System.out.print(k);
				System.out.println(p.getRolls());
			});

			return new ArrayList<BowlingPlayer>(players.values());

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Verify if the roll has adequate syntax and value.<br>
	 * Format may be a number in range from 0 to 10, or "F" in case of a foul.
	 * 
	 * @param roll	String representation of a roll.
	 * @throws Exception	In case of an invalid roll value.<br>
	 * @throws NumberFormatException	In case of an invalid roll format.
	 */
	private static boolean validRoll(String roll) throws Exception {
		
		if (!roll.equals(IBowling.FOUL)) {
			try {
				int value = Integer.parseInt(roll);
				if (value < 0 || value > 10) {
					throw new Exception("Invalid score value of: " + value);
				}
			} catch (NumberFormatException ex) {
				throw new NumberFormatException("Incorrect roll format: ["+roll+"] isn't a valid roll. \nException details: "+ex.getMessage());
			}
		}

		return true;
	}

}
