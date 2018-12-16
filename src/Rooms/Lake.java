package Rooms;

import Game.Runner;
import People.Person;

public class Lake extends Room{
    public Lake(int x, int y) {
        super(x, y);
    }

    /**
     * Triggers the
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("");
    }
    @Override
    public String toString(){
        return("[L]");
    }
}
