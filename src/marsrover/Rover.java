package marsrover;

import java.util.EnumMap;

public class Rover {
    Location currentPos;
    Plateau plateau;
    
	public Rover(Plateau p, Location l) {
		currentPos = l;
		plateau = p;
	}
	
	public void turnLeft() {
		EnumMap<Direction, Direction> leftTurnMap = createLeftTurnMap();
		currentPos.setOrientation(leftTurnMap.get(currentPos.getOrientation()));
	}

	private EnumMap<Direction, Direction> createLeftTurnMap() {
		EnumMap<Direction, Direction> leftTurn = new EnumMap<Direction, Direction>(Direction.class);
		leftTurn.put(Direction.NORTH, Direction.WEST);
		leftTurn.put(Direction.SOUTH, Direction.EAST);
		leftTurn.put(Direction.EAST, Direction.NORTH);
		leftTurn.put(Direction.WEST, Direction.SOUTH);
		return leftTurn;
	}
	
	public void turnRight() {
		EnumMap<Direction, Direction> rightTurnMap = createRightTurnMap();
		currentPos.setOrientation(rightTurnMap.get(currentPos.getOrientation()));
	}
	
	private EnumMap<Direction, Direction> createRightTurnMap() {
		EnumMap<Direction, Direction> leftTurn = new EnumMap<Direction, Direction>(Direction.class);
		leftTurn.put(Direction.NORTH, Direction.EAST);
		leftTurn.put(Direction.SOUTH, Direction.WEST);
		leftTurn.put(Direction.EAST, Direction.SOUTH);
		leftTurn.put(Direction.WEST, Direction.NORTH);
		return leftTurn;
	}
	
	public void move() {
		int newX = currentPos.getCoordinate().getX();
		int newY = currentPos.getCoordinate().getY();
		
		switch(currentPos.getOrientation()) {
		    case NORTH:
		    	newY++;
		    	break;
		    case SOUTH:
		    	newY--;
		    	break;
		    case EAST:
		    	newX++;
		    	break;
		    case WEST:
		    	newX--;
		    	break;
		    default:
		    	break;
		}
		if (plateau.isCoordinateInBounds(newX, newY)) {
			currentPos.getCoordinate().setX(newX);
			currentPos.getCoordinate().setY(newY);
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public String outputLocation() {
		return currentPos.toString();
	}
	
}
