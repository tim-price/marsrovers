package marsrover.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import marsrover.Direction;

class DirectionTest {

	@Test
	void testToString() {
		Direction d = Direction.NORTH;
		assertEquals("N", d.toString());
		d = Direction.SOUTH;
		assertEquals("S", d.toString());
		d = Direction.EAST;
		assertEquals("E", d.toString());
		d = Direction.WEST;
		assertEquals("W", d.toString());
	}

	@Test
	void testFromString() {
		Direction d = Direction.fromString("N");
		assertEquals(Direction.NORTH, d);
		d = Direction.fromString("S");
		assertEquals(Direction.SOUTH, d);
		d = Direction.fromString("E");
		assertEquals(Direction.EAST, d);
		d = Direction.fromString("W");
		assertEquals(Direction.WEST, d);
	}
}
