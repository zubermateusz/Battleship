package battleship;

public enum Ships {

    AIRCRAFT_CARRIER("Aircraft Carrier" , 5, false, true),// 5- size of ship, false - is not set on field game
    BATTLESHIP("Battleship", 4, false, true),
    SUBMARINE("Submarine", 3, false, true),
    CRUISER("Cruiser", 3, false, true),
    DESTROYER("Destroyer", 2, false, true);

    private boolean isSetOfField;
    private boolean isAlive;
    int length;
    String name;
    Ships(String name, int length, boolean setFalg, boolean isAlive) {
        this.name = name;
        this.isSetOfField = setFalg;
        this.isAlive = isAlive;
        this.length = length;
    }

    public String getName() {
        return name;
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
