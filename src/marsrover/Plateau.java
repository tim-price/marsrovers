package marsrover;

public class Plateau {
    Point max;
    
	public Plateau(Point p) {
		max = p;
	}
	
	public boolean isCoordinateInBounds(int x, int y) {
		if ((x >= 0 && x <= max.getX()) && (y >= 0 && y <= max.getY())) {
			return true;
		}		
		return false;
	}
}
