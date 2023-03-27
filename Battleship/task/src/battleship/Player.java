package battleship;


public class Player {

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

    public void showGameField(){
        for (char[] chars : this.gameField) {
            System.out.print(chars);
            System.out.println();
        }
    }
}
