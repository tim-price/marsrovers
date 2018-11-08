package marsrover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MarsRovers {
    Plateau plateau;
    InputParser ip;
    BufferedReader reader;
    FileReader file;
    
	MarsRovers() {
	}
	
	void run() {
		try {
			Class cls = this.getClass();
			file = new FileReader(cls.getResource("input.txt").getPath());
	    	reader = new BufferedReader(file);
			ip = new InputParser();
			String s = readLineAndValidate();
			Point topRight = ip.parseUpperRightCoordinates(s);
			plateau = new Plateau(topRight);
			while (!ip.isEndOfFile(reader)) {
				s = readLineAndValidate();
				Rover rover = new Rover(plateau, ip.parseRoverPosition(s));
				s = readLineAndValidate();
				char[] actions = ip.parseRoverActions(s);
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
	
	String readLineAndValidate() {
		String line = ip.readLineFromFile(reader);
		ip.checkInputValid(line);
		return line;
	}
}
