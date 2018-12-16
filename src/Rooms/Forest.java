package Rooms;

import Game.Runner;
import People.Person;

public class Forest extends Room {
    public Forest(int x, int y) {
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
        return("[F]");
    }
}
