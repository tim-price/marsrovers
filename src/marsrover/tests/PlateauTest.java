package marsrover.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import marsrover.Plateau;
import marsrover.Point;

class PlateauTest {
	
	@Test
	void testCornersAreInBounds() {
		Plateau p = new Plateau(new Point(5, 5));
        assertTrue(p.isCoordinateInBounds(0,0));
        assertTrue(p.isCoordinateInBounds(0,5));
        assertTrue(p.isCoordinateInBounds(5,0));
        assertTrue(p.isCoordinateInBounds(5,5));
	}
	
	@Test
	void testInBounds() {
		Plateau p = new Plateau(new Point(3, 3));
        assertTrue(p.isCoordinateInBounds(1,2));
        assertTrue(p.isCoordinateInBounds(1,1));
        assertTrue(p.isCoordinateInBounds(2,1));
        assertTrue(p.isCoordinateInBounds(2,2));
	}
	
	@Test
	void testOutOfBounds() {
		Plateau p = new Plateau(new Point(2, 2));
        assertFalse(p.isCoordinateInBounds(4,2));
        assertFalse(p.isCoordinateInBounds(1,8));
        assertFalse(p.isCoordinateInBounds(-1,1));
        assertFalse(p.isCoordinateInBounds(2,-5));
	}

}
