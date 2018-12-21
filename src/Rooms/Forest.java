package Rooms;

import People.Person;

public class Forest extends Room {
    public Forest(int x, int y) {
        super(x, y);
    }

    public String getName(){
        return "Forest";
    }

    /**
     * Player going into the Forest
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        x.inForest(1);
        position = "[F]";
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        x.inForest();
        System.out.println("You can either run, hunt, or gather food? (R, H, or F)");
    }
}
