import Toys.SoftToy;
import Toys.Toy;

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
        giveAway(mostPossible(store, 30));


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




}