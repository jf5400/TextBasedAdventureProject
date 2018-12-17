package Rooms;

import People.Person;

public class Cornucopia extends Room{
    public Cornucopia(int x, int y) {
        super(x, y);
    }

    int start=0;

    public String getName(){
        return "Cornucopia";
    }

    /**
     * Triggers the game ending conditions. CHANGE
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        position = "[C]";
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);

        if(start==0){
            System.out.println("You're stuck in a simulatiom!");
            System.out.println("In order to get out you must go to the beach, the lake and the forest.");
            System.out.println("First, you must get your health to 100 by finding food and killing others.");
            start+=1;
        }
        else if(x.inForest() && x.inLake() && x.inBeach()){
            System.out.println("You've won the game!");
        }
        else {
            System.out.println("Get has much items as you could and run!!");
        }
    }
}
