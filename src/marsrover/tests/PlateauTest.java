package marsrover.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import marsrover.Plateau;
import marsrover.Point;

class PlateauTest {
	
	@Test
	void testCornersAreInBounds() {
		Plateau p = new Plateau(new Point(5, 5));
        assertTrue(p.isPointInBounds(new Point(0,0)));
        assertTrue(p.isPointInBounds(new Point(0,5)));
        assertTrue(p.isPointInBounds(new Point(5,0)));
        assertTrue(p.isPointInBounds(new Point(5,5)));
	}
	
	@Test
	void testInBounds() {
		Plateau p = new Plateau(new Point(3, 3));
        assertTrue(p.isPointInBounds(new Point(1,2)));
        assertTrue(p.isPointInBounds(new Point(1,1)));
        assertTrue(p.isPointInBounds(new Point(2,1)));
        assertTrue(p.isPointInBounds(new Point(2,2)));
	}
	
	@Test
	void testOutOfBounds() {
		Plateau p = new Plateau(new Point(2, 2));
        assertFalse(p.isPointInBounds(new Point(4,2)));
        assertFalse(p.isPointInBounds(new Point(1,8)));
        assertFalse(p.isPointInBounds(new Point(-1,1)));
        assertFalse(p.isPointInBounds(new Point(2,-5)));
	}

}
