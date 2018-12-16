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
        Room[][] building = new Room[5][5];
        Board map = new Board(building);

        for (int i=0; i<building.length; i++){
            for (int j=0; j<building[i].length; j++){
                building[i][j] = new Room(i,j);
            }
        }

        building[2][2] = new Cornucopia(3,3);

        building[2][1] = new Beach(2,1);
        building[2][3] = new Beach(2,3);
        for(int i=1; i<4; i++){
            building[1][i] = new Beach(1,i);
            building[3][i] = new Beach(3,i);
        }

        //Fill half of the remaining rooms with Lake or Forest rooms
        for (int x = 0; x<5; x++)
        {
            building[x][0] = new Lake(x,0);
            building[x][4] = new Forest(x,4);
        }
        for(int x=1; x<4;x++){
            building[0][x] = new Lake(0,x);
            building[4][x] = new Forest(4,x);
        }


        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        Contestant k = new Contestant(x, y);

        //Setup player 1 and the input scanner
        Person player1 = new Person("FirstName", "FamilyName", 2,2);
        building[2][2].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {
            while(player1.gethealth()>0){
                map.print();
                System.out.println("Where would you like to move? (Choose N, S, E, W)");
                String move = in.nextLine();

                // TO WIN GAME THEY HAVE TO FIND THE BOW AND ARROW AND MAKE IT BACK TO THE CORNICOPIA

                if(validMove(move, player1, building))
                {
                    System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());

                }
                else {
                    System.out.println("Please choose a valid move.");
                }
            }
        }
        in.close();
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
