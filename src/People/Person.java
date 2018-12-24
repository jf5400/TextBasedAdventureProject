package People;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
    String firstName;
    String familyName;
    int xLoc, yLoc;
    int numoffood;
    boolean Knife=false;
    int health;
    final int maxhealth=100;
    boolean Bowandarrow=false;
    boolean Lake = false;
    boolean Forest = false;


    // To see if they went to a Lake Room
    public boolean inLake(){
        return Lake = true;
    }
    public boolean Lake(){
        return Lake;
    }


    // To see if they went to a Forest Room
    public boolean inForest(){
        return Forest=true;
    }
    public boolean Forest(){
        return Forest;
    }

    public int gethealth(){
        return health;
    }

    public int addhealth(int n){
        return health+n;
    }

    public boolean hasKnife(){
        return Knife=true;
    }

    public boolean getKnife(){
        return Knife;
    }

    public boolean getBowandarrow(){
        return Bowandarrow;
    }
    public boolean hasBowandarrow(){return Bowandarrow = true;}

    public void eatfood(int n){
        if(health < maxhealth - n){
            addhealth(10);
        }
        else{
            health = maxhealth;
        }
        numoffood-=1;
    }

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