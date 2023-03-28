package battleship;


public class Player {

    //The symbol O denotes a cell with your ship, X denotes that the ship was hit, and M signifies a miss.
    private char[][] gameField = new char[10][10];


    public Player(){
        startGameField();
        showGameField();
    }

    private void startGameField(){
        for (int row = 0; row < this.gameField.length; row++){//set '~' in whole game field
            for (int column = 0; column < this.gameField[row].length; column++){// add ~ ~ ~ ~ ~ ~
                this.gameField[row][column] = '~';
            }
        }
    }// set clear field

    public void setShipOnGameField(Ships ship, String playerCoordinates){
        //split playerCoordinates to two coordinates,
        //after split first is row A B C .. and column 0 - 10
        int[][] coordinates = coordinatesToSplit(playerCoordinates);
        coordinates = changeCoordinatesFromMinToMax(coordinates);
        if(checkLengthOfCoordinates(ship, coordinates)){ // length ship == length coordinates
            //-----------------------------------------------------
        }
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
        boolean coordinatesVertical = false;
        boolean coordinatesHorizontal = false;
        // first check coordinates are in only one row or column
        //it should show "Error! Wrong ship location! Try again:"
        if(coordinates[0][0] == coordinates[1][0]) {//A2 A4
            coordinatesHorizontal = true;
        }
        if(coordinates[0][1] == coordinates[1][1]) {//A2 C2
            coordinatesVertical = true;
        }
        if(coordinatesHorizontal == coordinatesVertical) { //B9 D8 or B9 B9 (to small ship)
            System.out.println("Error! Wrong ship location! Try again:");
            return false;
        }
        // check length of coordinates to ship
        if (coordinates[1][0] - coordinates[0][0] == ship.getLength() - 1) {
            goodLengthShipFlag = true;
        } // row A B C ... J
        if (coordinates[1][1] - coordinates[0][1] == ship.getLength() - 1) {
            goodLengthShipFlag = true;
        }
        if(goodLengthShipFlag) {
            System.out.println("Error! Wrong length of the " + ship.name() + "! Try again:");
            return false;
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
        coordinatesForField[0][0] = coordinatesAfterSplit[0].charAt(0) - 65;// row A B C... J (- 65 kod ASCII 'A')
        coordinatesForField[0][1] = Integer.parseInt(coordinatesAfterSplit[0].substring(1));// column 1 2 3 ... 10
        coordinatesForField[1][0] = coordinatesAfterSplit[1].charAt(0) - 65;// row A B C... J
        coordinatesForField[1][1] = Integer.parseInt(coordinatesAfterSplit[1].substring(1));// column 1 2 3 ... 10
        return coordinatesForField;
    } // return coordinates in int[][]; coordinates (0 2)(2 2)

    public void showGameField(){
        //first row 1 2 3 4 5 6 ... 10
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        char sign = 'A';
        for (int row = 0; row < this.gameField.length; row++) {
            System.out.print((char)(sign + row));//A B C D ... J
            for (int column = 0; column < this.gameField[row].length; column++) {// print ~ ~ ~ ~ ~ ~
                System.out.print(' ');
                System.out.print(gameField[row][column]);//print sign from gameField
            }
            System.out.println();//new line
        }
    } // print player field on screen

    private void printCoordinates(int[][] coordinates){
        System.out.println(coordinates[0][0]);
        System.out.println(coordinates[0][1]);
        System.out.println(coordinates[1][0]);
        System.out.println(coordinates[1][1]);
    }//only to print - check coordinates
}
