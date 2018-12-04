public class Board {
    private Room[][] map;
    public Board(Room [][] map){
        this.map=map;
    }

    for(int i=0; i<map.length; i++){
        for(int j=0; j<map.length; j++) {
            System.out.println(map[i][j]);
        }
    }

}
