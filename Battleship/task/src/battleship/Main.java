package battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        Player player1 = new Player();


        Scanner playerCoordinates = new Scanner(System.in);
        System.out.println("Enter the coordinates of the " + Ships.AIRCRAFT_CARRIER.getName() + " (" + Ships.AIRCRAFT_CARRIER.getLength() + " cells):");
        player1.setShipOnGameField(Ships.AIRCRAFT_CARRIER, playerCoordinates.nextLine());
        if(!Ships.AIRCRAFT_CARRIER.getSetOnField()) {
            player1.setShipOnGameField(Ships.AIRCRAFT_CARRIER, playerCoordinates.nextLine());

        }

        System.out.println("Enter the coordinates of the " + Ships.BATTLESHIP.getName() + " (" + Ships.BATTLESHIP.getLength() + " cells):");
        player1.setShipOnGameField(Ships.BATTLESHIP, playerCoordinates.nextLine());
        if(!Ships.BATTLESHIP.getSetOnField()) {
            player1.setShipOnGameField(Ships.BATTLESHIP, playerCoordinates.nextLine());
        }

        System.out.println("Enter the coordinates of the " + Ships.SUBMARINE.getName() + " (" + Ships.SUBMARINE.getLength() + " cells):");
        player1.setShipOnGameField(Ships.SUBMARINE, playerCoordinates.nextLine());
        if(!Ships.SUBMARINE.getSetOnField()) {
            player1.setShipOnGameField(Ships.SUBMARINE, playerCoordinates.nextLine());
        }

        System.out.println("Enter the coordinates of the " + Ships.CRUISER.getName() + " (" + Ships.CRUISER.getLength() + " cells):");
        player1.setShipOnGameField(Ships.CRUISER, playerCoordinates.nextLine());
        if(!Ships.CRUISER.getSetOnField()) {
            player1.setShipOnGameField(Ships.CRUISER, playerCoordinates.nextLine());
        }

        System.out.println("Enter the coordinates of the " + Ships.DESTROYER.getName() + " (" + Ships.DESTROYER.getLength() + " cells):");
        player1.setShipOnGameField(Ships.DESTROYER, playerCoordinates.nextLine());
        if(!Ships.DESTROYER.getSetOnField()) {
            player1.setShipOnGameField(Ships.DESTROYER, playerCoordinates.nextLine());
        }

    }
}
