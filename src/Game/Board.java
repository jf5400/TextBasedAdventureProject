package Game;

import Rooms.Room;
import Rooms.Beach;
import Rooms.Forest;
import Rooms.Lake;

public class Board {
    private Room[][] map;
    private boolean hardLevel = false;

    public boolean ifHardLevel(){
        return hardLevel;
    }

    public Board(Room [][] map){
        this.map=map;
    }

    public Board(Room [][] map, boolean sm){
        hardLevel=true;
        this.map=map;
    }

    public void print(){
        String row="";
        for(int i=0; i<map.length; i++){
            row="";
            for(int j=0; j<map[i].length; j++) {
                row+=map[i][j].toString();
            }
            System.out.println(row);
        }
    }

}
