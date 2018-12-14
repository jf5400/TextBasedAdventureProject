package Game;

import People.Person;
import Rooms.Room;
import Rooms.Cornucopia;
import Rooms.Lake;
import Rooms.Forest;

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

        //do it for 5 rooms instead
        building[3][3] = new Cornucopia(3,3);

        //Fill half the building with Lake rooms
        for (int x = 0; x<(building.length)/2; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Lake(x,y);
            }
        }

        //Fill half the building with Forest rooms
        for (int x = 5; x<(building.length)/2; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Lake(x,y);
            }
        }


        //Setup player 1 and the input scanner
        Person player1 = new Person("FirstName", "FamilyName", 3,3);
        building[2][2].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            map.print();
            String move = in.nextLine();
            if(validMove(move, player1, building))
            {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());

            }
            else {
                System.out.println("Please choose a valid move.");
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
