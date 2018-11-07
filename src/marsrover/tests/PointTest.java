package marsrover.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import marsrover.Point;

class PointTest {

	@Test
	void testCreate() {
		Point p = new Point(1, 1);
		assertNotNull(p);
	}
	
	@Test
	void testGet() {
		Point p = new Point(10, 24);
		assertEquals(10, p.getX());
		assertEquals(24, p.getY());
	}
	
	@Test
	void testSet() {
		Point p = new Point(10, 24);
		
		p.setX(4);
		assertEquals(4, p.getX());
		assertEquals(24, p.getY());
		
		p.setY(15);		
		assertEquals(4, p.getX());
		assertEquals(15, p.getY());
	}

}
