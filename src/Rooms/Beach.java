package Rooms;

import People.Person;

public class Beach extends Room{
    public Beach(int x, int y) {
        super(x, y);
    }

    public String getName(){
        return "Beach";
    }

    String position = "[B]";
    /**
     * Triggers the game ending conditions. CHANGE
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("Hurry, you don't want to be on the beach for too long! Everyone can see you!");
    }
}