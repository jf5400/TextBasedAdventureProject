package Items;
import People.Person;

public class Food implements Item {
    public void use(Person p){
        if(p.getnumoffood()<0) {
            p.eatfood();
        }
        else{
            System.out.println("There's no more food");
        }
    }
    public String getName(){
        return "Food";
    }
}
