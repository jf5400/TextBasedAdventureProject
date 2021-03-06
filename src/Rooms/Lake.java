package Rooms;

import People.Person;

import java.util.Scanner;

import Game.Board;
import Items.Knife;

public class Lake extends Room{
    public Lake(int x, int y) {
        super(x, y);
    }

    public String getName(){
        return "Lake";
    }

    Knife there= new Knife();

    /**
     * Player going into the Lake
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x, Board b) {
        x.inLake();
        position = "[L]";
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);


        Scanner in = new Scanner(System.in);
        System.out.println("Would you like to either run, hunt, or gather food? (R, H, or F)");
        String choice= in.nextLine();
        choice = choice.toLowerCase().trim();
        if(choice.equals("h")){

            if(x.getKnife()){

                int hunt=(int)(Math.random()*2);
                if(hunt==0){
                    System.out.println("You caught a fish in the lake!");
                    x.eatfood(10);
                }
                else{
                    System.out.println("You hurt yourself while hunting, pay attention to you health next time!");
                    x.addhealth(-10);
                }
                there.use(x);

            }
            else{
                System.out.println("You don't have a knife, you have to run somwhere else :( ");
            }
        }
        else if(choice.equals("f")){

            System.out.println("Will you find food?");
            int fate_1 = (int)(Math.random()*2);
            if(fate_1 == 0){
                System.out.println("You found food! Let's eat some!");
                x.eatfood(10);
            }
            else{
                System.out.println("You couldn't find any food, you should eat to keep your health up");
            }
        }
        else{

            int fate_2 = (int)(Math.random()*2);
            if(fate_2 == 1){
                System.out.println("You dripped while running and got hurt! I hope your health isn't too low");
                x.addhealth(-10);
            }
        }

    }
}
