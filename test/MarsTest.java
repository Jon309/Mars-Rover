import org.junit.Test;

import static org.junit.Assert.*;

public class MarsTest {

    @Test
    public void sampleInputOne(){

        int maxX = 5;
        int maxY = 5;
        Mars.checkNegativeValues(maxX, maxY);

        String roverInitial[] = {"1","2","N"};
        String roverCommands = "LMLMLMLMM";

        Rover testRover = new Rover(Integer.parseInt(roverInitial[0]), Integer.parseInt(roverInitial[1]),
                roverInitial[2].charAt(0));

        Mars.checkMaxValues(Integer.parseInt(roverInitial[0]), Integer.parseInt(roverInitial[1]), maxX, maxY);
        Mars.checkNegativeValues(Integer.parseInt(roverInitial[0]), Integer.parseInt(roverInitial[1]));

        Mars.executeCommands(roverCommands, testRover);

        String solution = testRover.getX() + " " + testRover.getY() + " " + testRover.getCurrentDirection();
        assertEquals(("1 3 N"), solution);
    }

    @Test
    public void sampleInputTwo(){

        int maxX = 5;
        int maxY = 5;
        Mars.checkNegativeValues(maxX, maxY);

        String roverInitial[] = {"3","3","E"};
        String roverCommands = "MMRMMRMRRM";

        Rover testRover = new Rover(Integer.parseInt(roverInitial[0]), Integer.parseInt(roverInitial[1]),
                roverInitial[2].charAt(0));

        Mars.checkMaxValues(Integer.parseInt(roverInitial[0]), Integer.parseInt(roverInitial[1]), maxX, maxY);
        Mars.checkNegativeValues(Integer.parseInt(roverInitial[0]), Integer.parseInt(roverInitial[1]));

        Mars.executeCommands(roverCommands, testRover);

        String solution = testRover.getX() + " " + testRover.getY() + " " + testRover.getCurrentDirection();
        assertEquals(("5 1 E"), solution);
    }

}
