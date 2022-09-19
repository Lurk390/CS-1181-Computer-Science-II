// Mahmoud Elbasiouny

package HW2_ShoppingTrip;

public class Driver {
    public static void main(String[] args) {
        Product[] products = new Product[4];

        // Create two necessary and two luxury products and add them to the products array
        products[0] = new NecessaryProduct("Cheese", 1.50);
        products[1] = new LuxuryProduct("Soda", 3.50, 0.0575);
        products[2] = new NecessaryProduct("Bread", 2.25);
        products[3] = new LuxuryProduct("Candy", 2.00, 0.0575);

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
