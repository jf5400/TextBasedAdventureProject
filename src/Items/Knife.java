package Items;
import People.Person;

public class Knife implements Item{
    public void use(Person p){
        System.out.println("You used your knife! Your health will go up!");
        if(p.getKnife()) {
            p.addhealth(5);
        }
    }

    public String getName(){
        return("Knife");
    }
}
