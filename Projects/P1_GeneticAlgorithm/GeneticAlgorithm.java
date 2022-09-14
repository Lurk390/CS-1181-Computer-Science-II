// Mahmoud Elbasiouny

package P1_GeneticAlgorithm;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GeneticAlgorithm {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Item> items = new ArrayList<>();
        items = readData("items.txt");
        ArrayList<Chromosome> population = initializePopulation(items, 100);
    }
    

    public static ArrayList<Item> readData(String filename) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filename));
        ArrayList<Item> items = new ArrayList<>();

        while(input.hasNextLine()){
            String line = input.nextLine();
            String[] tokens = line.split(", ");

            String name = tokens[0];
            double weight = Double.parseDouble(tokens[1]);
            int value = Integer.parseInt(tokens[2]);
            
            items.add(new Item(name, weight, value));
        }
        input.close();
        return items;
    }

    
    public static ArrayList<Chromosome> initializePopulation(ArrayList<Item> items, int populationSize) {
        ArrayList<Chromosome> population = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            population.add(new Chromosome(items));
        }
        return population;
    }
}
