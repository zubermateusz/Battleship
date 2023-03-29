package battleship;


import java.util.Arrays;

public class Player {

    //The symbol O denotes a cell with your ship, X denotes that the ship was hit, and M signifies a miss.
    private char[][] gameField = new char[10][10];


    public Player(){
        startGameField();
        showGameField();
    }

    private void startGameField(){
        for (int row = 0; row < this.gameField.length; row++){//set '~' in whole game field
            // add ~ ~ ~ ~ ~ ~
            Arrays.fill(this.gameField[row], '~');
        }
    }// set clear field


    public boolean setShipOnGameField(Ships ship, String playerCoordinates){
        //split playerCoordinates to two coordinates,
        //after split first is row A B C .. and column 0 - 10
        int[][] coordinates = coordinatesForShipToSplit(playerCoordinates);
        coordinates = changeCoordinatesFromMinToMax(coordinates);

        if(!checkLengthOfCoordinates(ship, coordinates)) { // length ship == length coordinates
            System.out.println("Error! Wrong length of the " + ship.getName() + "! Try again:");
            System.out.println();
            return false;
        }
        if(!checkSpaceForShip(coordinates)) {
            System.out.println("Error! You placed it too close to another one. Try again:");
            System.out.println();
            return false;
        }
        if(!checkCoordinatesInOneLine(coordinates)) {
            System.out.println("Error! Wrong ship location! Try again:");
            System.out.println();
            return false;
        }

        //set ship on gamefield
        for (int row = coordinates[0][0]; row <= coordinates[1][0]; row++) {
            for (int column = coordinates[0][1]; column <= coordinates[1][1]; column++) {
                this.gameField[row][column] = 'o';
            }
        }

        ship.setSetOnField(true);
        showGameField();
        return true;
    }

    private boolean checkSpaceForShip(int[][] coordinates){
        for (int row = coordinates[0][0] - 1; row <= coordinates[1][0] + 1 && row + 1 < 10; row++) {
            if (row == -1) { // protection to not exceed the boundaries of the board
                row = 0;
            }
            for (int column = coordinates[0][1] - 1; column <= coordinates[1][1] + 1 && column + 1 < 10; column++) {
                if (column == -1) { // protection to not exceed the boundaries of the board
                    column = 0;
                }
                if(gameField[row][column] != '~') {
                    return false;
                }
            }
        }
        return true;
    } // check space around coordinates ships cannot connect

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

    private boolean checkCoordinatesInOneLine(int[][] coordinates){ // check length of ship from coordinates
        boolean coordinatesVertical = coordinates[0][1] == coordinates[1][1];//A2 C2
        boolean coordinatesHorizontal = coordinates[0][0] == coordinates[1][0];//A2 A4

        if(coordinatesHorizontal == coordinatesVertical) { //B9 D8 or B9 B9 (to small ship)
            return false;
        }

        return  coordinatesHorizontal != coordinatesVertical;
    } // return true if coordinates are in one line

    private boolean checkLengthOfCoordinates(Ships ship, int[][] coordinates){ // check length of ship from coordinates
        boolean goodLengthShipFlag = false;

        // check length of coordinates to ship
        if (coordinates[1][0] - coordinates[0][0] + 1 == ship.getLength()) {
            goodLengthShipFlag = true;
        } // row A B C ... J
        if (coordinates[1][1] - coordinates[0][1] + 1 == ship.getLength()) {
            goodLengthShipFlag = true;
        }

        /* not necessery now
        // check board boundaries
        // J8 J10 -> J8 + ship.length < right border
        // J8 J10 -> J10 - ship.length > left border
        int shipLength = ship.length;
        if (coordinates[0][0] + shipLength > 10) {
            goodLengthShipFlag = false;
            System.out.println("Złe koordynaty1");
        }
        if (coordinates[0][1] + shipLength > 10) {
            goodLengthShipFlag = false;
            System.out.println("Złe koordynaty2");
        }
        if (coordinates[1][0] - shipLength < 0) {
            goodLengthShipFlag = false;
            System.out.println("Złe koordynaty3");
        }
        if (coordinates[1][1] - shipLength < 0) {
            goodLengthShipFlag = false;
            System.out.println("Złe koordynaty4");
        }

         */

        return goodLengthShipFlag;
    } // return true if coordinates and length are ok

    private int[][] coordinatesForShipToSplit(String coordinates){
        int[][] coordinatesForField = new int[2][2];
        String[] coordinatesAfterSplit = coordinates.split(" ");
        coordinatesForField[0][0] = coordinatesAfterSplit[0].charAt(0) - 65;// row A B C... J (- 65 kod ASCII 'A')
        coordinatesForField[0][1] = Integer.parseInt(coordinatesAfterSplit[0].substring(1)) - 1;// column (0) for array 1 2 3 ... 10
        coordinatesForField[1][0] = coordinatesAfterSplit[1].charAt(0) - 65;// row A B C... J
        coordinatesForField[1][1] = Integer.parseInt(coordinatesAfterSplit[1].substring(1)) - 1;// column (0) for array 1 2 3 ... 10
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
        System.out.println();
    } // print player field on screen

    private void printCoordinates(int[][] coordinates){
        System.out.println(coordinates[0][0]);
        System.out.println(coordinates[0][1]);
        System.out.println(coordinates[1][0]);
        System.out.println(coordinates[1][1]);
    }//only to print - check coordinates

    public boolean shot(Player player, String nextLine) {
        int[] coordinates = readCoordinatesToShot(nextLine);
        if (!player.isCoordinatesOnField(coordinates)) {
            return false;
        }
        if (player.isShipHit(coordinates)) {
            System.out.println("You hit a ship!");
            System.out.println();
        } else {
            System.out.println("You missed!");
            System.out.println();
        }
        return true;
    }

    private boolean isCoordinatesOnField(int[] coordinates) {
        if (coordinates[0] < gameField.length && coordinates[1] < gameField[0].length) {
            return true;
        } else {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            System.out.println();
            return false;
        }
    }

    private boolean isShipHit(int[] coordinates) {
        return gameField[coordinates[0]][coordinates[1]] == 'o';
    }

    private int[] readCoordinatesToShot(String nextLine) {
        int[] coordinatesForField = new int[2];
        coordinatesForField[0] = nextLine.charAt(0) - 65;// row A B C... J (- 65 kod ASCII 'A')
        coordinatesForField[1] = Integer.parseInt(nextLine.substring(1)) - 1;// column (0) for array 1 2 3 ... 10
        return coordinatesForField;
    }
}
