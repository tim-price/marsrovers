package marsrover;

public class Plateau {
    int xMax;
    int yMax;
    
	public Plateau(int x, int y) {
		xMax = x;
		yMax = y;
	}
	
	public boolean isCoordinateInBounds(int x, int y) {
		if ((x >= 0 && x <= xMax) && (y >= 0 && y <= yMax)) {
			return true;
		}		
		return false;
	}
}
