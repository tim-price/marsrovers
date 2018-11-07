package marsrover;

public enum Direction {
    NORTH,
    SOUTH, 
    EAST, 
    WEST;
	
	@Override
	public String toString() {
		switch(this) {
			case NORTH: 
				return "N";
			case SOUTH: 
				return "S";
			case EAST: 
				return "E";
			case WEST: 
				return "W";
			default:
				throw new IllegalArgumentException();
		}
	}
	
	public static Direction fromString(String name) {
		switch(name) {
		case "N": 
			return NORTH;
		case "S": 
			return SOUTH;
		case "E": 
			return EAST;
		case "W": 
			return WEST;
		default:
			throw new IllegalArgumentException();
		}
	}
}
