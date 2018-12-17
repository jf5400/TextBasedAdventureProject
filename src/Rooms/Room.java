package Rooms;

import People.Person;

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
    }

    public static String getName(Person x){
        return "";
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        System.out.println("You enter a plain old room");
        occupant = x;
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
