public class Rover {

    private int x = 0;
    private int y = 0;
    private char currentDirection = 'N';
    private int currentIndex = 0;
    private char validDirections[] = {'N', 'E', 'S', 'W'};


    // Constructor
    public Rover(int x, int y, char currentDirection) {
        this.x = x;
        this.y = y;
        this.currentDirection = currentDirection;

        getDirectionIndex(currentDirection);
    }


    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getCurrentDirection() {
        return currentDirection;
    }

    private void getDirectionIndex(char currentDirection){
        int index = 0;
        if(currentDirection == 'N')
            currentIndex = 0;
        else if(currentDirection == 'E')
            currentIndex = 1;
        else if(currentDirection == 'S')
            currentIndex = 2;
        else if(currentDirection == 'W')
            currentIndex = 3;
    }

    //



    // Validations
    private boolean isValidDirection(char currentDirection){
        if (currentDirection == 'N' || currentDirection == 'E' || currentDirection == 'S' || currentDirection == 'W')
            return true;
        else
            return false;
    }

    private boolean isValidCommand(char currentCommand){
        if (currentCommand == 'L' || currentCommand == 'R' || currentCommand == 'M')
            return true;
        else
            return false;
    }

    private boolean hasReachedEdge(char currentDirection){
        if (currentDirection == 'N' && y == Mars.getMaxY()){
            return true;
        }
        else if (currentDirection == 'S' && y == 0){
            return true;
        }
        else if (currentDirection == 'E' && x == Mars.getMaxX()){
            return true;
        }
        else if (currentDirection == 'W' && x == 0){
            return true;
        }
        else
            return false;
    }



    void changeDirection(char currentCommand){
        if(isValidCommand(currentCommand)) {

            if (currentCommand == 'L') {
                lowerIndex();
            }
            else if (currentCommand == 'R') {
                increaseIndex();
            }
            indexToDirection();
        }
        else {
            System.out.println("Invalid command");
            System.exit(1);
        }

    }

    private void increaseIndex(){
        if (currentIndex==3){
            currentIndex=0;
        }
        else {
            currentIndex++;
        }
        indexToDirection();

    }

    private void lowerIndex(){
        if (currentIndex==0){
            currentIndex=3;
        }
        else {
            currentIndex--;
        }
        indexToDirection();
    }

    private void indexToDirection() {
        currentDirection = validDirections[currentIndex];
    }


    // Movement
    private void moveVertical(char currentDirection){
        if (!hasReachedEdge(currentDirection)){
            if (currentDirection == 'N')
                this.y++;
            if (currentDirection == 'S')
                this.y--;
        }
        else
            System.out.println("Skipping command. Reached edge of grid.");
    }

    private void moveHorizontal(char currentDirection){
        if (!hasReachedEdge(currentDirection)){
            if (currentDirection == 'E')
                this.x++;
            if (currentDirection == 'W')
                this.x--;
        }
        else
            System.out.println("Skipping command. Reached edge of grid.");
    }

    void moveForward(){
        if (isValidDirection(currentDirection)){
            if (currentDirection == 'N' || currentDirection == 'S'){
                moveVertical(currentDirection);
            }
            else if (this.currentDirection == 'E' || currentDirection == 'W'){
                moveHorizontal(currentDirection);
            }
        }
        else {
            System.out.println("Invalid direction");
            System.exit(1);
        }

    }

}


