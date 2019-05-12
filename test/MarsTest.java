import org.junit.Test;

import static org.junit.Assert.*;

public class MarsTest {

    Mars testMars =  new Mars();

    @Test
    public void sampleInputOne(){

        testMars.maxX = 5;
        testMars.maxY = 5;
        testMars.checkNegativeValues(testMars.maxX, testMars.maxY);

        String roverInitial[] = {"1","2","N"};
        String roverCommands = "LMLMLMLMM";

        Rover testRover = new Rover(Integer.parseInt(roverInitial[0]), Integer.parseInt(roverInitial[1]),
                roverInitial[2].charAt(0));

        testMars.checkMaxValues(Integer.parseInt(roverInitial[0]), Integer.parseInt(roverInitial[1]), testMars.maxX, testMars.maxY);
        testMars.checkNegativeValues(Integer.parseInt(roverInitial[0]), Integer.parseInt(roverInitial[1]));

        testMars.executeCommands(roverCommands, testRover);

        String solution = testRover.getX() + " " + testRover.getY() + " " + testRover.getCurrentDirection();
        assertEquals(("1 3 N"), solution);
    }

    @Test
    public void sampleInputTwo(){

        testMars.maxX = 5;
        testMars.maxY = 5;
        testMars.checkNegativeValues(testMars.maxX, testMars.maxY);

        int maxX = 5;
        int maxY = 5;
        Mars.checkNegativeValues(maxX, maxY);

        String roverInitial[] = {"3","3","E"};
        String roverCommands = "MMRMMRMRRM";

        Rover testRover = new Rover(Integer.parseInt(roverInitial[0]), Integer.parseInt(roverInitial[1]),
                roverInitial[2].charAt(0));

        testMars.checkMaxValues(Integer.parseInt(roverInitial[0]), Integer.parseInt(roverInitial[1]), testMars.maxX, testMars.maxY);
        testMars.checkNegativeValues(Integer.parseInt(roverInitial[0]), Integer.parseInt(roverInitial[1]));

        testMars.executeCommands(roverCommands, testRover);

        String solution = testRover.getX() + " " + testRover.getY() + " " + testRover.getCurrentDirection();
        assertEquals(("5 1 E"), solution);
    }

}
