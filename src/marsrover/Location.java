package marsrover;

public class Location {
    Point coordinate;
    Direction orientation;
    
    public Location(Point p, Direction facing) {
    	coordinate = p;
    	orientation = facing;
    }

	public Point getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Point coordinate) {
		this.coordinate = coordinate;
	}

	public Direction getOrientation() {
		return orientation;
	}

	public void setOrientation(Direction orientation) {
		this.orientation = orientation;
	}
    
	@Override
	public String toString() {
		String s = coordinate.getX() + " ";
		s += coordinate.getY() + " ";
		s += orientation + "\n";
		return s;
	}
    
}
