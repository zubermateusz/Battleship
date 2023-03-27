package battleship;


public class Player {

    //The symbol O denotes a cell with your ship, X denotes that the ship was hit, and M signifies a miss.
    private char[][] gameField = new char[11][22];


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
    }

    public void setShipOnGameField(Ships ship, String playerCoordinates){
        //split playerCoordinates to two coordinates,
        //after split first is row A B C .. and columnt 0 - 10
        

    }

    private boolean checkLengthOfCoordinates(Ships ship, int[][] coordinates){ // check length of ship from coordinates
        boolean goodLengthShipFlag = false;
        if (Math.max(coordinates[0][0], coordinates[1][0]) - Math.min(coordinates[0][0], coordinates[1][0]) == ship.getLength()) {
            goodLengthShipFlag = true;
        } // row A B C ... J
        if (Math.max(coordinates[0][1], coordinates[1][1]) - Math.min(coordinates[0][1], coordinates[1][1]) == ship.getLength()) {
            goodLengthShipFlag = true;
        }
        return goodLengthShipFlag;
    }
    private int[][] coordinatesToSplit(String coordinates){
        int[][] coordinatesForField = new int[2][2];
        String[] coordinatesAfterSplit = coordinates.split(" ");
        coordinatesForField[0][0] = coordinatesAfterSplit[0].charAt(0) - 65;// row A B C... J (- 65 kod ASCII 'A'
        coordinatesForField[0][1] = Integer.parseInt(coordinatesAfterSplit[0].substring(1));// column 1 2 3 ... 10
        coordinatesForField[1][0] = coordinatesAfterSplit[1].charAt(0) - 65;// row A B C... J
        coordinatesForField[1][1] = Integer.parseInt(coordinatesAfterSplit[1].substring(1));// column 1 2 3 ... 10
        return coordinatesForField;
    }
    public void showGameField(){
        for (char[] chars : this.gameField) {
            System.out.print(chars);
            System.out.println();
        }
    }
}
