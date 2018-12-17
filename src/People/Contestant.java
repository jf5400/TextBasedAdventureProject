package People;

public class Contestant{
    int xLoc, yLoc;
    boolean inRoom=false;

    public boolean ifinRoom(){
        return inRoom;
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

    public Contestant (int xLoc, int yLoc)
    {
        this.xLoc = xLoc;
        this.yLoc = yLoc;

    }

}
