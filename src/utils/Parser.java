package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import models.Player;

public class Parser {

	public static HashMap<String, Player> parseRolls(File file) throws Exception {

		try {
			HashMap<String, Player> players = new HashMap<>();
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {

				String[] data = sc.nextLine().split(" ");

				String playerName = data[0];

				String roll = data[1];

				if (players.containsKey(playerName)) {
					if (validRoll(roll)) {
						players.get(playerName).addRoll(roll);
					}
				} else {
					players.put(playerName, new Player(playerName));
				}
			}
			sc.close();

			//TODO: Remove this code when finish.
			players.forEach((k, p) -> {
				System.out.print(k);
				System.out.println(p.getRolls());
			});
			
			return players;
			
		} catch (FileNotFoundException e) {
			throw e;
		}

	}

	private static boolean validRoll(String roll) throws Exception {
		if (!roll.equals("F")) {
			try {
				int value = Integer.parseInt(roll);
				if (value < 0 || value > 10) {
					throw new Exception("Invalid score value of: " + value);
				}
			} catch (NumberFormatException ex) {
				throw new Exception("Incorrect roll format: " + roll);
			}
		}

		return true;
	}

	public boolean addRoll(String roll) throws NumberFormatException {

		if (roll.equals("F")) {

		} else {
			try {
				int rollValue = Integer.parseInt(roll);
			} catch (NumberFormatException ex) {
				throw new NumberFormatException("Can't parse roll value: " + roll);
			}
		}

		// TODO: Add validations, can the player roll ? etc.
		return false;
	}

}
