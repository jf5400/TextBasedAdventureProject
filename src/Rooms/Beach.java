package Rooms;

import People.Person;

import java.util.Scanner;
import Game.Board;

public class Beach extends Room{
    public Beach(int x, int y) {
        super(x, y);
    }

    public String getName(){
        return "Beach";
    }

    // To see if this is the first time the player is going into this type of room.
    int start = 0;

    /**
     * For the challenge levels
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x, Board b) {
        position = "[B]";
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);


        if(start==0){
            System.out.println("You are in the hard levels!/nThis means that you have access to the beach where the best food is, but where a lot of scary animals go!");
            System.out.println("Also, you have to find the Bow and Arrow! However, it could be anywhere on the board");
        }

        Scanner in =new Scanner(System.in);
        System.out.println("Hurry, you don't want to be on the beach for too long!/nDo you want to run or explore the beach! (R or E)");
        String choice= in.nextLine();
        choice = choice.toLowerCase().trim();

        if(choice.equals("e")){
            System.out.println("You decided to explore! Let's see if something good happens!");
            int fate = 3 + (int)(Math.random());
            if(fate==0){
                System.out.println("You found some coconuts! These are great for your health!");
                x.eatfood( 15);
            }
            if(fate==1){
                System.out.println("You got stung by a sting ray! You got hurt again :(");
                x.addhealth(-10);
            }
            if(fate==2){
                System.out.println("A turtle bit your toe! You got hurt again");
                x.addhealth(-5);
            }
        }
    }
}