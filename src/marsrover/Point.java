package marsrover;

public class Point {
	int x;
    int y;
    
    public Point (int latitude, int longitude) {
    	x = latitude;
    	y = longitude;
    }
    
    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
