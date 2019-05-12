import java.util.*;

public class Mars {

    public static int maxX;
    public static int maxY;

    public static void main(String[] args){

        Scanner readData = new Scanner(System.in);

        String numbers[] = readData.nextLine().split(" ");
        maxX = Integer.parseInt(numbers[0]);
        maxY = Integer.parseInt(numbers[1]);
        checkNegativeValues(maxX, maxY);

        System.out.println("Type q to quit");
        while(!readData.hasNext("q")){
            String roverInitial[] = readData.nextLine().toUpperCase().split(" ");

            checkMaxValues(Integer.parseInt(roverInitial[0]), Integer.parseInt(roverInitial[1]), maxX, maxY);
            checkNegativeValues(Integer.parseInt(roverInitial[0]), Integer.parseInt(roverInitial[1]));

            String roverCommands = readData.nextLine().toUpperCase();

            Rover rover = new Rover(Integer.parseInt(roverInitial[0]), Integer.parseInt(roverInitial[1]),
                    roverInitial[2].charAt(0));

            executeCommands(roverCommands, rover);

            System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getCurrentDirection());
        }
    }

    public static void executeCommands(String roverCommands, Rover rover) {
        for(char command : roverCommands.toCharArray()){
                if (command == 'L')
                    rover.changeDirection('L');
                else if (command == 'R')
                    rover.changeDirection('R');
                else if (command == 'M')
                    rover.moveForward();
                else {
                    System.out.println("Disconnecting from Rover... Goodbye");
                    System.exit(1);
                }
            }
    }

    public static void checkMaxValues(int x, int y, int maxX, int maxY) {
        if (x > maxX || y > maxY) {
            System.out.print("Initial coordinates must be inside NASA's grid!");
            System.exit(1);
        }
    }

    public static void checkNegativeValues(int x, int y) {
        if (x < 0 || y < 0) {
            System.out.print("Initial coordinates cannot be negative!");
            System.exit(1);
        }
    }
}
