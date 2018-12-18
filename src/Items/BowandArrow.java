package Items;

import People.Person;

public class BowandArrow {
    public void use(Person p){
        p.addhealth(50);
    }

    public String getName(){
        return("Bow and Arrow");
    }
}
