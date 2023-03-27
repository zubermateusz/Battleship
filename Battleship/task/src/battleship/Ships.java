package battleship;

public enum Ships {

    AIRCRAFT_CARRIER(5, false, true),// 5- size of ship, false - is not set on field game
    BATTLESHIP(4, false, true),
    SUBMARINE(3, false, true),
    CRUISER(3, false, true),
    DESTROYER(2, false, true);

    private boolean isSet;
    private boolean isAlive;
    Ships(int i, boolean setFalg, boolean isAlive) {
        this.isSet = setFalg;
        this.isAlive = isAlive;
    }

    public void setSet(boolean set){
        this.isSet = set;
    }

    public boolean getSet(){
        return this.isSet;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
