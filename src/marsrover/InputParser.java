package marsrover;

import java.io.BufferedReader;
import java.io.IOException;

public class InputParser {
    
    public InputParser() {
    }
    
    public Point parseUpperRightCoordinates(String firstLine) {
        String[] values = firstLine.split("\\s+");
        Point p = new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        return p;
    }
    
    public Location parseRoverPosition(String line) {
        String[] values = line.split("\\s+");
        Point p = new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        Location l = new Location(p, Direction.fromString(values[2]));
        return l;
    }
    
    public char[] parseRoverActions(String line) {
        return line.toCharArray();
    }
    
    public boolean isEndOfFile(BufferedReader reader) throws IOException {
        reader.mark(1);
        int i = reader.read();
        reader.reset();
        return i < 0;
    }
    
    public String readLineFromFile(BufferedReader reader) {
        String line = "";
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
    
    public void checkInputValid(String line) {
        if (line.length() == 0) {
            throw new IllegalArgumentException();
        }
    }
}
