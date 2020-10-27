package models.games;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

import models.Game;
import models.games.bowling.Frame;
import models.players.BowlingPlayer;

public class BowlingGame extends Game {

	public BowlingGame(List<BowlingPlayer> players) {
		super(players);
		results = new HashMap<>();
		initialize(players);
	}
	
	private void initialize(List<BowlingPlayer> players) {
		players.forEach(player -> {
			try {
				List<Frame> frames = assignRolls(player);
				calculateScore(frames);
				results.put(player, frames);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private List<Frame> assignRolls(BowlingPlayer player) {
		
		 List<Frame>frames = new ArrayList<>();
		 Queue<String> rolls = player.getRolls();
		 
		 int i = 0;
		 while(i < MAX_FRAMES) {
			 Frame frame = new Frame();
			 boolean isFinalFrame = i == 9;
			 int remainingRolls = isFinalFrame ? 3 : 2;
			 
			 while(remainingRolls > 0) {
				 
				 String roll = rolls.isEmpty() ? null : rolls.remove();
				 
				 // No more rolls to retrieve.
				 if(roll == null) {
					 i = MAX_FRAMES;
					 break;
				 }
				 
				 int rollValue = roll.equals(FOUL) ? 0 : Integer.parseInt(roll);
				 
				 if(!isFinalFrame) {
					 if(remainingRolls == 1) {
						 if((frame.getRemainingPins() - rollValue) == 0) {
							 frame.registerRoll(SPARE);
						 }
						 else {
							 frame.registerRoll(roll);
						 }
					 }
					 else {
						 if(roll.equals("10")) {
							 frame.registerRoll(STRIKE);
							 remainingRolls = 0;
							 break;
						 }
						 else {
							 frame.registerRoll(roll);
						 } 
					 }
				 }
				 else { // Final Frame	 
					  if(roll.equals("10")) {
						  frame.registerRoll(STRIKE);
					  }
					  else if(frame.getRemainingPins() - rollValue == 0) {
						  frame.registerRoll(SPARE);
					  }
					  else {
						  frame.registerRoll(roll);
					  }
				 }
				 
				 remainingRolls--;
			 }
			 
			 frames.add(frame);
			 i++;
		 }
		 
		 return frames;
	}
	
	public void calculateScore(List<Frame> frames) {
		
	}

	@Override
	public void printResults() {
		System.out.println("Frame\t\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10");
		
		results.forEach((player, frames) ->{
			System.out.println(player.getName());
			System.out.print("Pinfalls\t");
			frames.forEach(f -> {
				StringBuilder output = new StringBuilder();
				List<String> pinfalls = f.getPinfalls();
				if(pinfalls.size() == 1) {
					output.append("  "+pinfalls.get(0));
				}
				else {
					pinfalls.forEach(p -> output.append(p+"  "));
				}
				System.out.print(output.toString()+"\t");
				});
			System.out.print("\nScore\t\t");
			frames.forEach(f ->{
				System.out.print(f.getScore()+"\t");
			});
			System.out.println();
		});
	}
	
	private HashMap<BowlingPlayer, List<Frame>> results;
	
	// Game constants.
	public static final int MAX_FRAMES = 10;
	public static final String FOUL = "F";
	public static final String SPARE = "/";
	public static final String STRIKE = "X";
}
