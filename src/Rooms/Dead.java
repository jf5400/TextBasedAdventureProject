package Rooms;
import People.Person;

import People.Person;

public class Dead extends Room{
    public Dead(int x, int y) {
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
}
