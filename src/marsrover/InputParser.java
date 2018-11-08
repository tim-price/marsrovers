package marsrover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputParser {
    BufferedReader reader;
    FileReader file;
    String actions;
    
    public InputParser(String filename) {
    	try {
	    	file = new FileReader(filename);
	    	reader = new BufferedReader(file);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public Point parseUpperRightCoordinates() {
    	String firstLine = readLineFromFile();
    	checkInputValid(firstLine);
    	String[] values = firstLine.split("/s");
    	Point p = new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    	return p;
    }
    
    public Location parseRoverPosition() {
    	String line = readLineFromFile();
    	checkInputValid(line);
    	String[] values = line.split("/s");
    	Point p = new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    	Location l = new Location(p, Direction.fromString(values[2]));
    	return l;
    }
    
    public char[] parseRoverActions() {
    	String line = readLineFromFile();
    	checkInputValid(line);
    	return line.toCharArray();
    }
    
    public boolean isEndOfFile() throws IOException {
    	file.mark(1);
        int i = file.read();
        file.reset();
        return i < 0;
    }
    
    private String readLineFromFile() {
    	String line = "";
    	try {
	    	line = reader.readLine();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return line;
    }
    
    private void checkInputValid(String line) {
    	if (line.length() == 0) {
    		throw new IllegalArgumentException();
    	}
    }
}
