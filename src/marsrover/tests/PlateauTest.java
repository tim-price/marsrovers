package marsrover.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import marsrover.Plateau;

class PlateauTest {
	
	@Test
	void testCornersAreInBounds() {
		Plateau p = new Plateau(5, 5);
        assertTrue(p.IsCoordinateInBounds(0,0));
        assertTrue(p.IsCoordinateInBounds(0,5));
        assertTrue(p.IsCoordinateInBounds(5,0));
        assertTrue(p.IsCoordinateInBounds(5,5));
	}
	
	@Test
	void testInBounds() {
		Plateau p = new Plateau(3, 3);
        assertTrue(p.IsCoordinateInBounds(1,2));
        assertTrue(p.IsCoordinateInBounds(1,1));
        assertTrue(p.IsCoordinateInBounds(2,1));
        assertTrue(p.IsCoordinateInBounds(2,2));
	}
	
	@Test
	void testOutOfBounds() {
		Plateau p = new Plateau(2, 2);
        assertFalse(p.IsCoordinateInBounds(4,2));
        assertFalse(p.IsCoordinateInBounds(1,8));
        assertFalse(p.IsCoordinateInBounds(-1,1));
        assertFalse(p.IsCoordinateInBounds(2,-5));
	}

}
