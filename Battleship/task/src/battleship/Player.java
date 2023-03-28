package battleship;


public class Player {

    //The symbol O denotes a cell with your ship, X denotes that the ship was hit, and M signifies a miss.
    private char[][] gameField = new char[10][10];


    public Player(){
        startGameField();
        showGameField();
    }

    private void startGameField(){
        // add first row
        this.gameField[0] = new char[]{' ', ' ', '1', ' ', '2', ' ', '3', ' ', '4', ' ', '5', ' ', '6', ' ', '7', ' ', '8', ' ', '9', ' ', '1','0'};
        // next rows
        char firstSign = 'A'; // B C D E F G H I J
        for (int row = 1; row < this.gameField.length; row++){
            this.gameField[row][0] = (char) (firstSign + row - 1); // add A B C D...
            for (int column = 1; column < this.gameField[row].length - 1; column += 2){// add ~ ~ ~ ~ ~ ~
                this.gameField[row][column] = ' ';
                this.gameField[row][column + 1] = '~';
            }
            this.gameField[row][this.gameField[row].length - 1] = ' '; // last element in row ' '
        }
    }// set clear field

    public void setShipOnGameField(Ships ship, String playerCoordinates){
        //split playerCoordinates to two coordinates,
        //after split first is row A B C .. and columnt 0 - 10




    }

    private int[][] changeCoordinatesFromMinToMax(int[][] coordinates){
        int tempCoordiMin = Math.min(coordinates[0][0], coordinates[1][0]);
        int tempCoordiMax = Math.max(coordinates[0][0], coordinates[1][0]);
        coordinates[0][0] = tempCoordiMin;
        coordinates[1][0] = tempCoordiMax;
        tempCoordiMin = Math.min(coordinates[0][1], coordinates[1][1]);
        tempCoordiMax = Math.max(coordinates[0][1], coordinates[1][1]);
        coordinates[0][1] = tempCoordiMin;
        coordinates[1][1] = tempCoordiMax;
        return coordinates;
    } // change J10 J8 -> J8 J10

    private boolean checkLengthOfCoordinates(Ships ship, int[][] coordinates){ // check length of ship from coordinates
        boolean goodLengthShipFlag = false;
        // check length of coordinates to ship
        if (coordinates[1][0] - coordinates[0][0] == ship.getLength() - 1) {
            goodLengthShipFlag = true;
        } // row A B C ... J
        if (coordinates[1][1] - coordinates[0][1] == ship.getLength() - 1) {
            goodLengthShipFlag = true;
        }
        // check board boundaries
        // J8 J10 -> J8 + ship.length < right border
        // J8 J10 -> J10 - ship.length > left border
        if (coordinates[0][0] + ship.getLength() > 10) {
            goodLengthShipFlag = false;
            System.out.println("Złe koordynaty1");
        }
        if (coordinates[0][1] + ship.getLength() > 10) {
            goodLengthShipFlag = false;
            System.out.println("Złe koordynaty2");
        }
        if (coordinates[1][0] - ship.getLength() < 0) {
            goodLengthShipFlag = false;
            System.out.println("Złe koordynaty3");
        }
        if (coordinates[1][1] - ship.getLength() < 0) {
            goodLengthShipFlag = false;
            System.out.println("Złe koordynaty4");
        }

        return goodLengthShipFlag;
    } // return true if length is ok
    private int[][] coordinatesToSplit(String coordinates){
        int[][] coordinatesForField = new int[2][2];
        String[] coordinatesAfterSplit = coordinates.split(" ");
        coordinatesForField[0][0] = coordinatesAfterSplit[0].charAt(0) - 65;// row A B C... J (- 65 kod ASCII 'A'
        coordinatesForField[0][1] = Integer.parseInt(coordinatesAfterSplit[0].substring(1));// column 1 2 3 ... 10
        coordinatesForField[1][0] = coordinatesAfterSplit[1].charAt(0) - 65;// row A B C... J
        coordinatesForField[1][1] = Integer.parseInt(coordinatesAfterSplit[1].substring(1));// column 1 2 3 ... 10
        return coordinatesForField;
    } // return coordinates in int[][]
    public void showGameField(){

    } // print player field on screen

    private void printCoordinates(int[][] coordinates){
        System.out.println(coordinates[0][0]);
        System.out.println(coordinates[0][1]);
        System.out.println(coordinates[1][0]);
        System.out.println(coordinates[1][1]);
    }//only to print - check coordinates
}
