package models;

import java.util.ArrayList;
import java.util.List;

import utils.FrameCalculator;

public class TraditionalBowlingGame extends BowlingGame implements FrameCalculator{

	public TraditionalBowlingGame(List<Player> players) {
		super(players);
	}

	@Override
	public List<Integer> getFrames(List<String> rolls) {
		
		int frameCount = 0;
		List<Integer> previous = new ArrayList<>();
		boolean accumulate = false;
		int rollsCount = 0;
		
		while(frameCount < FRAMES) {
			
		}
		
		return null;
	}
	
	public static final int FRAMES = 10;
}
