package Rooms;

import Game.Runner;
import People.Person;

public class Forest extends Room {
    public Forest(int x, int y) {
        super(x, y);
    }

    public String getName(){
        return "Forest";
    }

    /**
     * Triggers the game ending conditions. CHANGE
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {

        position = "[F]";
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        x.inForest();
        System.out.println("enter");
    }
}
