// Mahmoud Elbasiouny
package HW2_ShoppingTrip;

public class NecessaryProduct extends Product {

    public NecessaryProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double getTotalPrice() {
        return getPrice();
    }
}
