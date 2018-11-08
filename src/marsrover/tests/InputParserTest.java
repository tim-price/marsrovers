package marsrover.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;


import marsrover.InputParser;
import marsrover.Point;
import marsrover.Location;
import marsrover.Direction;

class InputParserTest {

	@Test
	void testPlateauCoordinates() {
		InputParser ip = new InputParser();
		String s = "5 5";
		Point p = ip.parseUpperRightCoordinates(s);
		assertEquals(5, p.getX());
		assertEquals(5, p.getY());
	}
	
	@Test
	void testRoverPosition() {
		InputParser ip = new InputParser();
		String s = "1 2 N";
		Location l = ip.parseRoverPosition(s);
		assertEquals(1, l.getCoordinate().getX());
		assertEquals(2, l.getCoordinate().getY());
		assertEquals(Direction.NORTH, l.getOrientation());
	}
	
	@Test
	void testRoverActions() {
		InputParser ip = new InputParser();
		String s ="LMLMLMLMM";
		char[] actions = ip.parseRoverActions(s);
		char[] expected = new char[] {'L', 'M', 'L', 'M', 'L', 'M', 'L', 'M', 'M'};
		assertArrayEquals(expected, actions);
	}
	
	@Test
	void testEndOfFile() {
		try {
			Class cls = this.getClass();
		    FileReader file = new FileReader(cls.getResource("testinput.txt").getPath());
		    BufferedReader reader = new BufferedReader(file);
		    InputParser ip = new InputParser();
		    String line = ip.readLineFromFile(reader);
			ip.checkInputValid(line);
			boolean result = ip.isEndOfFile(reader);
			assertFalse(result);
			line = ip.readLineFromFile(reader);
			ip.checkInputValid(line);
			ip.parseRoverPosition(line);
			line = ip.readLineFromFile(reader);
			ip.checkInputValid(line);
			ip.parseRoverActions(line);
			
			result = ip.isEndOfFile(reader);
			assertFalse(result);
			
			line = ip.readLineFromFile(reader);
			ip.checkInputValid(line);
			ip.parseRoverPosition(line);
			line = ip.readLineFromFile(reader);
			ip.checkInputValid(line);
            ip.parseRoverActions(line);
            result = ip.isEndOfFile(reader);
            assertTrue(result);
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
