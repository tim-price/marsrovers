package marsrover;

public class Plateau {
    int xMax;
    int yMax;
    
	Plateau(int x, int y) {
		xMax = x;
		yMax = y;
	}
	
	Boolean IsCoordinateInBounds(int x, int y) {
		if ((x >= 0 && x <= xMax) && (y >= 0 && y <= yMax)) {
			return true;
		}		
		return false;
	}
}
