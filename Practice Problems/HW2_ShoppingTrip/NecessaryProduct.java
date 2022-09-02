// Mahmoud Elbasiouny

package HW2_ShoppingTrip;

public class NecessaryProduct extends Product {
    private double taxRate;

    public NecessaryProduct(String name, double price, double taxRate) {
        super(name, price);
        this.taxRate = taxRate;
    }

    @Override
    public double getTotalPrice() {
        return getPrice() * (1 + taxRate);
    }
}
