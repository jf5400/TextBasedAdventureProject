package Game;

import Rooms.Room;
import Rooms.Beach;
import Rooms.Forest;
import Rooms.Lake;

public class Board {
    private Room[][] map;
    private boolean hardLevel = false;

    public boolean isHardLevel(){
        return hardLevel;
    }

    public Room[][] getMap() {
        return map;
    }

    public Board(Room [][] map, int n){
        for (int i=0; i<map.length; i++){
            for (int j=0; j<map[i].length; j++){
                map[i][j] = new Room(i,j);
            }
        }
        for(int i=1; i<n-1;i++){
            if(i!=n/2){
                map[n/2][i] = new Lake(n/2,i);
            }
        }

        for(int i=1; i<n-1; i++){
            map[1][i] = new Forest(1,i);
            map[n-2][i] = new Lake(n-2,i);
        }
        this.map=map;
    }

    public Board(Room [][] map, int n, boolean sm){
        hardLevel=true;
        for (int i=0; i<map.length; i++){
            for (int j=0; j<map[i].length; j++){
                map[i][j] = new Room(i,j);
            }
        }
        for(int y=(n/2)-1; y<(n/2);y++){
            map[n/2][y] =new Beach(n/2,y);
            map[n/2][y+2] =new Beach(n/2,y);
        }
        for (int y = (n/2)-1; y < (n/2)+2; y++) {
            map[(n/2)-1][y] = new Beach((n/2)-1, y);
            map[(n/2)+1][y] = new Beach((n/2)+1, y);
        }
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
