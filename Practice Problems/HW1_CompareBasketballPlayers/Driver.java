package HW1_CompareBasketballPlayers;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
        // Create three BasketballPlayer objects
        BasketballPlayer player1 = new BasketballPlayer("Mahmoud", "Elbasiouny", 18.3);
        BasketballPlayer player2 = new BasketballPlayer("Alex", "House", 12.6);
        BasketballPlayer player3 = new BasketballPlayer("Trace", "Jones", 15.7);

        // Put the player objects into an ArrayList
        ArrayList<BasketballPlayer> playerList = new ArrayList<BasketballPlayer>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);

        // Print out the ArrayList
        System.out.println("Unsorted player list: ");
        System.out.println(playerList + "\n");

        // Sort the ArrayList
        Collections.sort(playerList);

        // Print out the ArrayList a second time
        System.out.println("Sorted player list: ");
        System.out.println(playerList);
    }
}

/*
Your task is to write a class called BasketballPlayer. Your class should have the following fields and
methods:
private String firstName
private String lastName
private double ppg (points per game)
public BasketballPlayer – constructor that iniFalizes the fields of this object
public String toString – returns a String of the form lastName, firstName (ppg)

Your BasketballPlayer class also needs to implement the Comparable interface so that basketball players
can be compared to one another. Players should be sorted first by points per game (higher comes first),
then lexicographically by last name (ignoring case) and finally lexicographically by first name.

You also need to create a class called Driver.java with a main method. In main:
Create three BasketballPlayer objects
Put the player objects into an ArrayList
Print out the ArrayList
Sort the ArrayList
Print out the ArrayList a second Fme

Example output:
[Smith, Jay (12.7), Smith, DeShaun (12.7), Taylor, DeShaun (18.1)]
[Taylor, DeShaun (18.1), Smith, DeShaun (12.7), Smith, Jay (12.7)]
 */