package Items;
import People.Person;

public class Knife implements Item{
    public void use(Person p){
        if(p.getKnife()) {

        }
    }

    public String getName(){
        return("Knife");
    }
}
