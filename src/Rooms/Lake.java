package Rooms;

import Game.Runner;
import People.Person;

import java.util.Scanner;

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
        Scanner in =new Scanner(System.in);
        System.out.println("You can either run, hunt, or gather food? (R, H, or F)");
        String choice= in.nextLine();
        choice = choice.toLowerCase().trim();
        if(choice.equals("h")){
            if(x.getKnife()){

            }
            else{
                System.out.println("You don't have a knife, you have to run somwhere else :( ");
            }
        }
        else if(choice.equals("f")){
            System.out.println("Will you find food?");
            int num=(int)(Math.random()*2);
            if(num==0){
                System.out.println("You found food! Let's eat some!");
                x.eatfood();
            }
            else{
                System.out.println("You didn't eat any food, you should eat to keep your health up");
            }
        }
        else{
            int other=(int)(Math.random()*2);
            if(other==1){
                System.out.println("You dripped while running and got hurt! I hope your health isn't too low");
                x.addhealth(-10);
            }
        }

    }
}
