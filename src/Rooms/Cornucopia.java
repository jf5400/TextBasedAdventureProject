package Rooms;

import People.Person;
import Game.Board;
import Game.Runner;

import java.util.Scanner;

public class Cornucopia extends Room{
    public Cornucopia(int x, int y) {
        super(x, y);
    }

    // To keep track of the number of times the player goes into this type of room.
    int start=0;

    public String getName(){
        return "Cornucopia";
    }

    /**
     * Triggers the game ending conditions. CHANGE
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x, Board b) {
        position = "[C]";
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);


        if(start==0){
            System.out.println("You're stuck in a simulatiom!");
            System.out.println("In order to get out you must go to the lake and the forest.");
            System.out.println("First, you must get your health to 100 by finding food and doing different things./nBut if your health gets to 0 you're dead");
            start+=1;

            Scanner in =new Scanner(System.in);
            System.out.println("Would you like to look for items that you may need? (Y)");
            String choice_1= in.nextLine();
            choice_1 = choice_1.toLowerCase().trim();

            if(choice_1.equals("y")){

                Scanner in2 =new Scanner(System.in);
                System.out.println("Would you like to look in the boxes or behind the boxes? (I or B)");
                String choice_2= in.nextLine();
                choice_2 = choice_2.toLowerCase().trim();

                if(choice_2.equals("i")){

                    System.out.println("You found food! Your health will get better!");
                    x.eatfood(10);
                }
                else{

                    System.out.println("You looked behind the boxes and got attacked by a squirrel :(");
                    System.out.println("Now your health will be worse. You want to make sure it doesn't reach 0 or you're dead!");
                    x.addhealth(-10);
                }
                System.out.println("While running out of the Cornicopia you tripped over a knife. Now you can use it!");
                x.hasKnife();
            }
        }
        else if (x.Forest() && x.Lake()){
            if(b.isHardLevel() && x.getBowandarrow()) {
                System.out.println("You've won the game!");
                Runner.gameOff(x);
            }
        }
        else {

            System.out.println("Get has much items as you could and run!!");
            int fate=2+(int)(Math.random());

            if(fate==0) {

                System.out.println("You were able to find some food!");
                x.eatfood(10);
            }

            else if(x.getKnife()!=false && fate==1){
                System.out.println("You found a knife! Now you can use it!");
                x.hasKnife();
            }

            else {
                System.out.println("You got hurt! Check your health!!");
                x.addhealth(-10);
            }
        }

    }
}
