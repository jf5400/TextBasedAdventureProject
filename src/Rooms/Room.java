package Rooms;

import People.Person;
import People.Contestant;

public class Room {
    Person occupant;
    int xLoc,yLoc;
    String position;
    String name;

    public Room(int x, int y)
    {
        xLoc = x;
        yLoc = y;
        position = "[X]";
        this.name=name;
    }

    public String getName(){
        return name;
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    public void enterRoom(Contestant x)
    {
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveRoom(Person x)
    {
        occupant = null;
    }

    public String toString(){
        if(occupant!=null){
            return "[P]";
        }
        else{
            return position;
        }
    }
}
