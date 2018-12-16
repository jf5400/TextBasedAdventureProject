package Rooms;

import People.Person;

public class Beach extends Room{
    public Beach(int x, int y) {
        super(x, y);
    }

    /**
     * Triggers the game ending conditions. CHANGE
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    @Override
    public String toString(){
        return("[B]");
    }
}