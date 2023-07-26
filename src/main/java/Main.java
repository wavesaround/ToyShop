import Toys.SoftToy;
import Toys.Toy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int SIZE = 30;
    public static ArrayList<Toy> store = new ArrayList<>();

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        System.out.println("Press Enter for New Store");
        user_input.nextLine();

        store = newStore(SIZE);
        System.out.println(store);
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


}