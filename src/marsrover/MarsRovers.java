package marsrover;

public class MarsRovers {
    Plateau plateau;
    InputParser ip;
    
	MarsRovers() {
	}
	
	void run() {
		try {
			Class cls = this.getClass();
			ip = new InputParser(cls.getResource("input.txt").getPath());
			Point topRight = ip.parseUpperRightCoordinates();
			plateau = new Plateau(topRight);
			while (!ip.isEndOfFile()) {
				Rover rover = new Rover(plateau, ip.parseRoverPosition());
				char[] actions = ip.parseRoverActions();
				for (char action : actions) {
					switch(action) {
						case 'L':
							rover.turnLeft();
							break;
						case 'R':
							rover.turnRight();
							break;
						case 'M':
							rover.move();
							break;
						default:
							throw new IllegalArgumentException();
					}
				}
				System.out.print(rover.outputLocation());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
