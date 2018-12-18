package Game;

import People.Person;
import Rooms.Room;
import Rooms.Cornucopia;
import Rooms.Lake;
import Rooms.Forest;
import Items.Food;
import Items.Knife;
import People.Contestant;
import Rooms.Beach;

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

        if(dimen==5 || dimen==7){
            Scanner choice=new Scanner(System.in);
            System.out.println("Would you like to try the hard game? If yes press Y");
            decision = choice.nextLine();
            decision.toLowerCase().trim();
        }

        Room[][] building = new Room[dimen][dimen];

        Board map = new Board(building, dimen);

        if(decision.equals("y")){
            map = new Board(building, dimen, true );
            map.print();
        }

        FillBoard(building, dimen);

        int start=0;

        //Setup player 1 and the input scanner
        Person player1 = new Person("FirstName", "FamilyName", dimen/2,dimen/2);
        building[dimen/2][dimen/2].enterRoom(player1);
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
                // TO WIN GAME THEY HAVE TO FIND THE BOW AND ARROW AND MAKE IT BACK TO THE CORNICOPIA

                if(validMove(move, player1, building))
                {
                    System.out.println("");

                }
                else {
                    System.out.println("You can't run in that direction! Choose another quickly!");
                }
            }
        }
        in.close();
    }

    public static void printthreethings(Person p){
        System.out.println("Health: "+p.gethealth()+"\nFood: "+p.getnumoffood()+"\nHas Knife? "+p.getKnife());
    }

    Contestant[] list = new Contestant[28];

    public static void FillBoard(Room[][] building, int n){
        building[n/2][n/2] = new Cornucopia(n/2,n/2);

        for (int i=0; i<building.length; i++){
            for (int j=0; j<building[i].length; j++){
                building[i][j] = new Forest(i,j);
            }
        }

        //Fill half of the remaining rooms with Lake or Forest rooms
        for (int x = 0; x<n; x++)
        {
            building[x][0] = new Lake(x,0);
            building[x][n-1] = new Forest(x,n-1);
        }
        for(int x=1; x<n-1;x++){
            building[0][x] = new Lake(0,x);
            building[n-1][x] = new Forest(n-1,x);
        }

        for(int i=0; i<((n/2)+1)*n; i++){
            int x = (int)(Math.random()*building.length);
            int y = (int)(Math.random()*building.length);
            while(x==(n/2) && y==(n/2)) {
                building[x][y].enterRoom(list[i]);
            }
        }
    }



    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of rooms
     * @return
     */
    public static boolean validMove(String move, Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    System.out.println("You are in the "+map[p.getxLoc()-1][p.getyLoc()].getName());
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
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
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
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
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
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
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
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
    public static void gameOff()
    {
        gameOn = false;
    }



}
