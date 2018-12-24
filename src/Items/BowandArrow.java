package Items;

import People.Person;

public class BowandArrow {
    public void use(Person p){
        System.out.println("You found the bow and arrow!");
        System.out.println("Go back to the Cornucopia to win the game!");
        p.addhealth(50);
        p.hasBowandarrow();
    }

    public String getName(){
        return("Bow and Arrow");
    }
}
