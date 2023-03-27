package battleship;

public enum Ships {

    AIRCRAFT_CARRIER(5, false, true),// 5- size of ship, false - is not set on field game
    BATTLESHIP(4, false, true),
    SUBMARINE(3, false, true),
    CRUISER(3, false, true),
    DESTROYER(2, false, true);

    private boolean isSetOfField;
    private boolean isAlive;
    int length;
    Ships(int length, boolean setFalg, boolean isAlive) {
        this.isSetOfField = setFalg;
        this.isAlive = isAlive;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setSetOnField(boolean set){
        this.isSetOfField = set;
    }

    public boolean getSetOnField(){
        return this.isSetOfField;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
