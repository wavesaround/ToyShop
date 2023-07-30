import Toys.SoftToy;
import Toys.Toy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int SIZE = 3;
    public static ArrayList<Toy> store = new ArrayList<>();
    public static ArrayList<Toy> giveAwayStock = new ArrayList<>();

    public static void main(String[] args) {

        store = newStore(SIZE);                             // создаем магазин из SIZE игрушек

        giveAway(mostPossible(store, 30));       // разыгрываем одну игрушку с минимальным % веса

        releaseToy(giveAwayStock);                         // отдаем игрушку победителю и записываем в файл

    }

    public static ArrayList<Toy> newStore(int size) {
        ArrayList<Toy> store = new ArrayList<>();
        Scanner user_input = new Scanner(System.in);
        for (int i = 0; i < size + 1; i++) {
            System.out.println("Пожалуйста, введите параметры (3) новой игрушки через пробел");
            String newToy = user_input.nextLine();
            String[] options = newToy.split(" ");
            store.add(new SoftToy(options[0], Integer.parseInt(options[1]), Integer.parseInt(options[2])));
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
        if (!store.isEmpty()) {
            giveAwayStock.add(store.get(win_idx));
            store.removeAll(giveAwayStock);
            System.out.println("Розыгрыш прошел успешно");
        }
        else System.out.println("В магазине больше нет игрушек");
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
        else System.out.println("Список пуст");
    }


}