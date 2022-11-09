package Recursion;

class TowersOfHanoi {

    public static void main(String[] args) {
        toh(4, 'A', 'B', 'C');
    }

    public static void toh(int numRings, char from, char other, char to) {

        if (numRings == 1) {
            System.out.println("Move from " + from + " to " + to);
            return;
        }

        // move all the rings except the bottom one out of the way (i.e. to the other peg)
        toh(numRings-1, from, to, other);

        // move the bottom ring to the peg we want it at (the "to" peg)
        System.out.println("Move from " + from + " to " + to);

        // move all the remaining rings where we want them (the "to" peg)
        toh(numRings-1, other, from, to);
    }
}

