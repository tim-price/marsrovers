package marsrover;

public class Plateau {
    Point max;
    
	public Plateau(Point p) {
		max = p;
	}
	
	public boolean isPointInBounds(Point p) {
		return (isXInBounds(p.getX()) && isYInBounds(p.getY()));
	}
	
	private boolean isXInBounds(int x) {
		return (x >= 0 && x <= max.getX());
	}
	
	private boolean isYInBounds(int y) {
		return (y >= 0 && y <= max.getY());
	}
}
