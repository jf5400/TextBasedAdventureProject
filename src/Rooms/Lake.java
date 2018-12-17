package Rooms;

import Game.Runner;
import People.Person;

public class Lake extends Room{
    public Lake(int x, int y) {
        super(x, y);
    }

    @Override
    public String getName(){
        return "Lake";
    }

    /**
     * Triggers the
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        position = "[L]";
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("");
        x.inLake();
    }
}
