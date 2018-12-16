package People;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
    String firstName;
    String familyName;
    int xLoc, yLoc;
    int numoffood;
    boolean hasKnife=false;
    int health;
    final int maxhealth=100;
    boolean Bowandarrow=false;

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public int getnumoffood(){
        return numoffood;
    }

    public int gethealth(){
        return health;
    }

    public boolean getKnife(){
        return hasKnife;
    }

    public boolean getBowandarrow(){
        return Bowandarrow;
    }

    public void eatfood(){
        if(health<90){
            health+=10;
        }
        else{
            health=100;
        }
        numoffood-=1;
    }

    public Person (String firstName, String familyName, int xLoc, int yLoc)
    {
        this.firstName = firstName;
        this.familyName = familyName;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.numoffood = 0;
        this.health = 50;

    }


}