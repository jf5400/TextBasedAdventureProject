package Rooms;

import Game.Runner;
import People.Person;

public class Lake extends Room{
    public Lake(int x, int y) {
        super(x, y);
    }

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
        x.inLake();
        System.out.println("You can either run, hunt, or gather food? (R, H, or F)");
    }
}
