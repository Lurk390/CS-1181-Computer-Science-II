// Mahmoud Elbasiouny

package HW2_ShoppingTrip;

public class Driver {
    public static void main(String[] args) {
        Product[] products = new Product[4];

        // Create two necessary and two luxury products and add them to the products array
        products[0] = new NecessaryProduct("Milk", 2.99, 0.07);
        products[1] = new NecessaryProduct("Bread", 3.99, 0.07);
        products[2] = new LuxuryProduct("iPhone", 999.99);
        products[3] = new LuxuryProduct("MacBook", 1999.99);

        // Print each product and its price and calculate the total price
        double total = 0;
        for (Product p : products) {
            System.out.println(p);
            total += p.getTotalPrice();
        }

        // Display the total cost, rounded to the nearest cent 
        System.out.println("Total: $" + Math.round(total * 100) / 100.0);
    }
}
