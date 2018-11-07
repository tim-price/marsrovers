package marsrover.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import marsrover.Rover;
import marsrover.Plateau;
import marsrover.Direction;

class RoverTest {

	@Test
	void testCreate() {
		Plateau p = new Plateau(5, 5);
		Rover rover = new Rover(2, 2, p, "N");
		assertNotNull(rover);
	}
	
	@Test
	void testTurnLeft() {
		Plateau p = new Plateau(5, 5);
		Rover rover = new Rover(2, 2, p, "N");
		rover.turnLeft();
		String s = rover.outputLocation();
		assertEquals("2 2 W\n", s);
		
		rover.turnLeft();
		s = rover.outputLocation();
		assertEquals("2 2 S\n", s);
		
		rover.turnLeft();
		s = rover.outputLocation();
		assertEquals("2 2 E\n", s);
		
		rover.turnLeft();
		s = rover.outputLocation();
		assertEquals("2 2 N\n", s);
	}
	
	@Test
	void testTurnRight() {
		Plateau p = new Plateau(5, 5);
		Rover rover = new Rover(3, 4, p, "N");
		rover.turnRight();
		String s = rover.outputLocation();
		assertEquals("3 4 E\n", s);
		
		rover.turnRight();
		s = rover.outputLocation();
		assertEquals("3 4 S\n", s);
		
		rover.turnRight();
		s = rover.outputLocation();
		assertEquals("3 4 W\n", s);
		
		rover.turnRight();
		s = rover.outputLocation();
		assertEquals("3 4 N\n", s);
	}
	
	@Test
	void testMoveNorth() {
		Plateau p = new Plateau(5, 5);
		Rover rover = new Rover(3, 4, p, "N");
		rover.move();
		String s = rover.outputLocation();
		assertEquals("3 5 N\n", s);
	}
	
	@Test
	void testMoveEast() {
		Plateau p = new Plateau(5, 5);
		Rover rover = new Rover(3, 4, p, "E");
		rover.move();
		String s = rover.outputLocation();
		assertEquals("4 4 E\n", s);
	}
	
	@Test
	void testMoveSouth() {
		Plateau p = new Plateau(5, 5);
		Rover rover = new Rover(3, 4, p, "S");
		rover.move();
		String s = rover.outputLocation();
		assertEquals("3 3 S\n", s);
	}
	
	@Test
	void testMoveWest() {
		Plateau p = new Plateau(5, 5);
		Rover rover = new Rover(3, 4, p, "W");
		rover.move();
		String s = rover.outputLocation();
		assertEquals("2 4 W\n", s);
	}

}
