package marsrover.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import marsrover.Location;
import marsrover.Point;
import marsrover.Direction;

class LocationTests {

    @Test
    void testCreate() {
        Location l = new Location(new Point(1, 1), Direction.NORTH);
        assertNotNull(l);
    }
    
    @Test
    void testGetCoordinate() {
        Location l = new Location(new Point(3, 5), Direction.NORTH);
        Point p = l.getCoordinate();
        assertEquals(3, p.getX());
        assertEquals(5, p.getY());
    }
    
    @Test
    void testSetCoordinate() {
        Location l = new Location(new Point(3, 5), Direction.NORTH);
        Point p = l.getCoordinate();
        assertEquals(3, p.getX());
        assertEquals(5, p.getY());
        
        l.setCoordinate(new Point(6, 10));
        p = l.getCoordinate();
        assertEquals(6, p.getX());
        assertEquals(10, p.getY());
    }
    
    @Test
    void testGetOrientation() {
        Location l = new Location(new Point(3, 5), Direction.NORTH);
        Direction d = l.getOrientation();
        assertEquals(Direction.NORTH, d);
    }
    
    @Test
    void testSetOrientation() {
        Location l = new Location(new Point(3, 5), Direction.NORTH);
        Direction d = l.getOrientation();
        assertEquals(Direction.NORTH, d);
        
        l.setOrientation(Direction.SOUTH);
        d = l.getOrientation();
        assertEquals(Direction.SOUTH, d);
    }
}
