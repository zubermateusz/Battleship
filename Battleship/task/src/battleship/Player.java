package battleship;


public class Player {

    private char[][] gameField = new char[22][11];


    public Player(){
        startGameField();
        showGameField();
    }

    private void startGameField(){
        // add first row
        gameField[0] = new char[]{' ', ' ', '1', ' ', '2', ' ', '3', ' ', '4', ' ', '5', ' ', '6', ' ', '7', ' ', '8', ' ', '9', ' ', '1','0'};

    }

    public void showGameField(){
        for (char[] chars : this.gameField) {
            System.out.print(chars);
        }
    }
}
