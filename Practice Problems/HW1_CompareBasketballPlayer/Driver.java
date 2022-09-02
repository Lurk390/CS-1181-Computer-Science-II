// Mahmoud Elbasiouny

package HW1_CompareBasketballPlayer;
import java.util.ArrayList;
import java.util.Collections;

public class Driver {
    public static void main(String[] args) {
        // Create three BasketballPlayer objects
        BasketballPlayer player1 = new BasketballPlayer("Taylor", "DeShaun", 18.1);
        BasketballPlayer player2 = new BasketballPlayer("Smith", "DeShaun", 12.7);
        BasketballPlayer player3 = new BasketballPlayer("Smith", "Jay", 12.7);

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
