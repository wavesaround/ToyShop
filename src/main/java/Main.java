import Toys.SoftToy;
import Toys.Toy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int SIZE = 30;
    public static ArrayList<Toy> store = new ArrayList<>();
    public static ArrayList<Toy> giveAwayStock = new ArrayList<>();

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        System.out.println("Press Enter for New Store");
        user_input.nextLine();

        store = newStore(SIZE);

        for (int i = 0; i < 11; i++) {
            giveAway(mostPossible(store, 30));
        }
        releaseToy(giveAwayStock);

    }

    public static ArrayList<Toy> newStore(int size) {
        ArrayList<Toy> store = new ArrayList<>();

        for (int i = 0; i < size + 1; i++) {
            store.add(new SoftToy(getName(), 30, new Random().nextInt(30,101)));
        }
        return store;
    }

    public static String getName() {
        Random rand = new Random();
        return String.valueOf(Names.values()[rand.nextInt(Names.values().length -1)]);
    }

    public static int mostPossible(ArrayList<Toy> source, int minPercent) {
        int minProbability = minPercent;
        int win_idx = 0;
        for (Toy toy:source) {
            if (toy.getProbability() > minProbability) {
                win_idx = source.indexOf(toy);
                minProbability = toy.getProbability();
            }
        }
        return win_idx;
    }

    public static void giveAway(int win_idx) {
        giveAwayStock.add(store.get(win_idx));
        store.removeAll(giveAwayStock);
        System.out.println("Розыгрыш прошел успешно");
    }

    public static void releaseToy(ArrayList<Toy> toys) {
        if (!toys.isEmpty()) {
            Toy item = toys.get(0);
            toys.remove(0);
            try(FileWriter writer = new FileWriter("src/main/java/" +
                    "delivered.txt", true))
            {
                String text = item + "\n";
                writer.write(text);
                writer.flush();

                System.out.println("Данные записаны");
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        else return;
    }


}