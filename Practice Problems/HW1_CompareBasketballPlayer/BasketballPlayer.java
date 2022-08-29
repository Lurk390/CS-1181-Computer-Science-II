// Mahmoud Elbasiouny

package HW1_CompareBasketballPlayer;

class BasketballPlayer implements Comparable<BasketballPlayer> {
    private String firstName;
    private String lastName;
    private double ppg;

    public BasketballPlayer(String firstName, String lastName, double ppg) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ppg = ppg;
    }

    public String toString() {
        return lastName + ", " + firstName + " (" + ppg + ")";
    }

    public int compareTo(BasketballPlayer other) {
        if (this.ppg > other.ppg) {
            return -1;
        } else if (this.ppg < other.ppg) {
            return 1;
        } else {
            if (this.lastName.compareToIgnoreCase(other.lastName) < 0) {
                return -1;
            } else if (this.lastName.compareToIgnoreCase(other.lastName) > 0) {
                return 1;
            } else {
                if (this.firstName.compareToIgnoreCase(other.firstName) < 0) {
                    return -1;
                } else if (this.firstName.compareToIgnoreCase(other.firstName) > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}
