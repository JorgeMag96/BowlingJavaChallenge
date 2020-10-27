package utils;

import java.io.File;
import java.util.List;

import models.Player;

/**
 * 
 * @author jorge
 *
 * @param <T> - Type of player.
 */
public interface DataParser<T extends Player> {

	/**
	 * Parse the given text file into a list of players.<br><br>
	 * 
	 * 
	 * @param file
	 * @return List of Player objects
	 * @throws Exception - In case of a parse exception.
	 */
	public List<T> execute(File file) throws Exception;
	
}
