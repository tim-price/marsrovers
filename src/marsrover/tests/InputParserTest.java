package marsrover.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

import org.junit.jupiter.api.Test;


import marsrover.InputParser;
import marsrover.Point;
import marsrover.Location;
import marsrover.Direction;

class InputParserTest {

	@Test
	void testPlateauCoordinates() {
		Class cls = this.getClass();
		InputParser ip = new InputParser(cls.getResource("testinput.txt").getPath());
		Point p = ip.parseUpperRightCoordinates();
		assertEquals(5, p.getX());
		assertEquals(5, p.getY());
	}
	
	@Test
	void testRoverPosition() {
		Class cls = this.getClass();
		InputParser ip = new InputParser(cls.getResource("testinput.txt").getPath());
		ip.parseUpperRightCoordinates();
		Location l = ip.parseRoverPosition();
		assertEquals(1, l.getCoordinate().getX());
		assertEquals(2, l.getCoordinate().getY());
		assertEquals(Direction.NORTH, l.getOrientation());
	}
	
	@Test
	void testRoverActions() {
		Class cls = this.getClass();
		InputParser ip = new InputParser(cls.getResource("testinput.txt").getPath());
		ip.parseUpperRightCoordinates();
		ip.parseRoverPosition();
		char[] actions = ip.parseRoverActions();
		char[] expected = new char[] {'L', 'M', 'L', 'M', 'L', 'M', 'L', 'M', 'M'};
		assertArrayEquals(expected, actions);
	}
	
	@Test
	void testMultipleRovers() {
		Class cls = this.getClass();
		InputParser ip = new InputParser(cls.getResource("testinput.txt").getPath());
		ip.parseUpperRightCoordinates();
		ip.parseRoverPosition();
		ip.parseRoverActions();
		
		Location l = ip.parseRoverPosition();
		assertEquals(3, l.getCoordinate().getX());
		assertEquals(3, l.getCoordinate().getY());
		assertEquals(Direction.EAST, l.getOrientation());
		
		char[] actions = ip.parseRoverActions();
		char[] expected = new char[] {'M', 'M', 'R', 'M', 'M', 'R', 'M', 'R', 'R', 'M'};
		assertArrayEquals(expected, actions);
	}
	
	@Test
	void testEndOfFile() {
		try {
			Class cls = this.getClass();
			InputParser ip = new InputParser(cls.getResource("testinput.txt").getPath());
			ip.parseUpperRightCoordinates();
			boolean result = ip.isEndOfFile();
			assertFalse(result);
			ip.parseRoverPosition();
			ip.parseRoverActions();
			
			result = ip.isEndOfFile();
			assertFalse(result);
			
			ip.parseRoverPosition();
            ip.parseRoverActions();
            result = ip.isEndOfFile();
            assertTrue(result);
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
