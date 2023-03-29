package battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        Player player1 = new Player();


        Scanner playerCoordinates = new Scanner(System.in);
        System.out.println("Enter the coordinates of the " + Ships.AIRCRAFT_CARRIER.getName() + " (" + Ships.AIRCRAFT_CARRIER.getLength() + " cells):");
        player1.setShipOnGameField(Ships.AIRCRAFT_CARRIER, playerCoordinates.nextLine()); //"F3 F7");
        if(!Ships.AIRCRAFT_CARRIER.getSetOnField()) {
            player1.setShipOnGameField(Ships.AIRCRAFT_CARRIER, playerCoordinates.nextLine());

        }

        System.out.println("Enter the coordinates of the " + Ships.BATTLESHIP.getName() + " (" + Ships.BATTLESHIP.getLength() + " cells):");
        player1.setShipOnGameField(Ships.BATTLESHIP, playerCoordinates.nextLine()); //"A1 D1");
        if(!Ships.BATTLESHIP.getSetOnField()) {
            player1.setShipOnGameField(Ships.BATTLESHIP, playerCoordinates.nextLine());
        }

        System.out.println("Enter the coordinates of the " + Ships.SUBMARINE.getName() + " (" + Ships.SUBMARINE.getLength() + " cells):");
        player1.setShipOnGameField(Ships.SUBMARINE,  playerCoordinates.nextLine()); //"J10 J8");
        if(!Ships.SUBMARINE.getSetOnField()) {
            player1.setShipOnGameField(Ships.SUBMARINE, playerCoordinates.nextLine());
        }

        System.out.println("Enter the coordinates of the " + Ships.CRUISER.getName() + " (" + Ships.CRUISER.getLength() + " cells):");
        player1.setShipOnGameField(Ships.CRUISER,  playerCoordinates.nextLine()); //"B9 D9");
        if(!Ships.CRUISER.getSetOnField()) {
            player1.setShipOnGameField(Ships.CRUISER, playerCoordinates.nextLine());
        }

        System.out.println("Enter the coordinates of the " + Ships.DESTROYER.getName() + " (" + Ships.DESTROYER.getLength() + " cells):");
        player1.setShipOnGameField(Ships.DESTROYER, playerCoordinates.nextLine()); //"I2 J2");
        if(!Ships.DESTROYER.getSetOnField()) {
            player1.setShipOnGameField(Ships.DESTROYER, playerCoordinates.nextLine());
        }

        System.out.println("The game starts!");
        System.out.println();
        player1.showGameField();

        System.out.println("Take a shot!");
        while(!player1.shot(player1, playerCoordinates.nextLine())) {

        }


    }
}
