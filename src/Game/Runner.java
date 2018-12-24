package Game;

import Items.BowandArrow;
import People.Person;
import Rooms.Room;
import Rooms.Cornucopia;
import Rooms.Lake;
import Rooms.Forest;
import Game.Board;

import java.util.Scanner;

public class Runner {
    private static boolean gameOn = true;

    public static void main(String[] args)
    {
        int dimen=-1;
        while(dimen!=3 && dimen !=5 &&  dimen!=7){
            if(dimen==-1){
                Scanner other =new Scanner(System.in);
                System.out.println("What would you like the n to be for your n x n board to be? (3x3, 5x5, 7x7) (If n is 5 or 7 you can try the hard game)");
                dimen = other.nextInt() ;
            }
            else{
                Scanner other =new Scanner(System.in);
                System.out.println("Pick another for your board (3x3, 5x5, 7x7)");
                dimen = other.nextInt() ;
            }
        }

        String decision="";

        // To see if they want the harder level
        if(dimen==5 || dimen==7){
            Scanner choice=new Scanner(System.in);
            System.out.println("Would you like to try the hard game? If yes press Y");
            decision = choice.nextLine();
            decision.toLowerCase().trim();
        }

        Room[][] building = new Room[dimen][dimen];

        // One is for the challenge
        Board map = new Board(building,dimen);

        if(decision.equals("y")){
            map = new Board(building, dimen, true );
        }

        FillBoard(map, dimen);

        int start=0;

        BowandArrow challenge = new BowandArrow();

        //Setup player 1 and the input scanner
        Person player1 = new Person("FirstName", "FamilyName", dimen/2,dimen/2);
        building[dimen/2][dimen/2].enterRoom(player1, map);
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {
            while(player1.gethealth()>0){
                // To see if it is the beginning of the game
                if(start==0){
                    System.out.println("Here is your map:");
                    map.print();
                    System.out.println("If you would like to see the map again choose M");
                    System.out.println("If you would like to move choose N, S, E, W)");
                    start=1;
                }

                printthreethings(player1);

                System.out.println("Where would you like to move? (Choose N, S, E, W)");
                String move = in.nextLine();

                if(move.toLowerCase().trim().equals("m")){
                    map.print();
                }

                if(map.isHardLevel()){
                    if(player1.getxLoc()==0 && player1.getyLoc()==0) {
                        BowandArrow(player1, challenge);
                    }
                }

                if(validMove(move, player1, map))
                {
                    System.out.println("");

                }
                else {
                    System.out.println("You can't run in that direction! Choose another quickly!");
                }
            }
        }
        gameOff(player1);
        in.close();
    }

    public static void BowandArrow(Person p, BowandArrow b){
        b.use(p);
    }

    public static void printthreethings(Person p){
        System.out.println("Health: "+p.gethealth()+"\nHas Knife? "+p.getKnife());
    }

    //Fills the board with rooms
    public static void FillBoard(Board building, int n){
        Room[][] map = building.getMap();

        //Where the user starts
        map[n/2][n/2] = new Cornucopia(n/2,n/2);

        if(building.isHardLevel()){
            for (int x = 0; x<n; x++)
            {
                for (int y = 0; y<(n/2)-1; y++) {
                    map[x][y] = new Lake(x, y);
                    map[x][y+(n/2)+2] = new Forest(x, y);
                }
            }

            for(int y=1; y<n-1;y++){
                for(int x = 0; x<(n/2)-1; x++) {
                    map[x][y] = new Lake(x, y);
                    map[x+(n/2)+2][y] = new Forest(x+(n/2)+2, y);
                }
            }
        }
        else{
            //Fill half of the remaining rooms with Lake or Forest rooms
            for (int x = 0; x<n/2; x++)
            {
                map[x][n/2] = new Lake(x,0);
                map[x+(n/2)+1][n/2] = new Forest(x,n-1);
            }

            for(int x=0; x<n;x++){
                for(int y=0; y<n/2;y++){
                    map[x][y] = new Lake(x,y);
                    map[x][y+(n/2)+1] = new Forest(x,y);
                }
            }
        }
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param building to turn into the 2D array of rooms
     * @return
     */
    public static boolean validMove(String move, Person p, Board building )
    {
        Room[][] map = building.getMap();
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    System.out.println("You are in the "+map[p.getxLoc()-1][p.getyLoc()].getName());
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p,building);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    System.out.println("You are in the "+map[p.getxLoc()][p.getyLoc() + 1].getName());
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p, building);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    System.out.println("You are in the "+map[p.getxLoc()+1][p.getyLoc()].getName());
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p, building);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    System.out.println("You are in the "+map[p.getxLoc()][p.getyLoc()-1].getName());
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p, building);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;

        }
        return true;
    }
    public static void gameOff(Person p)
    {
        if(p.gethealth()<=0){
            System.out.println("You died :(");
        }
        gameOn = false;
    }



}
