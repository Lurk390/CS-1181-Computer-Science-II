// Mahmoud Elbasiouny

package HW2_ShoppingTrip;

public class LuxuryProduct extends Product {

    public LuxuryProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double getTotalPrice() {
        return getPrice();
    }
}
