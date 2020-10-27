package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import utils.bowling.BowlingRollsParser;

public class UnitTests {

	@Test
	public void incorrectFormatTest() {
		
		BowlingRollsParser parser = new BowlingRollsParser();
		
		assertThrows(NumberFormatException.class, () -> {
			parser.validRoll("A");
	    });
		
		try {
			assertTrue(parser.validRoll("F"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void incorrectValueTest() {
		
		BowlingRollsParser parser = new BowlingRollsParser();
		
		assertThrows(Exception.class, () -> {
			parser.validRoll("11");
	    });
		
		assertThrows(Exception.class, () -> {
			parser.validRoll("-1");
	    });
		
		try {
			assertTrue(parser.validRoll("10"));
			assertTrue(parser.validRoll("0"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
