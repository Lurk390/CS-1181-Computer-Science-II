// Mahmoud Elbasiouny

package HW2_ShoppingTrip;

public class LuxuryProduct extends Product {
    private double taxRate;

    public LuxuryProduct(String name, double price, double taxRate) {
        super(name, price);
        this.taxRate = taxRate;
    }

    @Override
    public double getTotalPrice() {
        return getPrice() * (1 + taxRate);
    }
}
