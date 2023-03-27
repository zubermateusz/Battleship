package battleship;

public enum Ships {

    AIRCRAFT_CARRIER(5, false),// 5- size of ship, false - is not set on field game
    BATTLESHIP(4, false),
    SUBMARINE(3, false),
    CRUISER(3, false),
    DESTROYER(2, false);

    private boolean flag;
    Ships(int i, boolean setFalg) {
        this.flag = setFalg;
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }

    public boolean getFlag(){
        return this.flag;
    }




}
