package Toys;

public class SoftToy extends Toy{

    protected int amount;

    public SoftToy(String name, int amount, int probability) {
        super(name, probability);
        this.amount = amount;
    }

    public void consumption(int number) {
        this.amount -= number;
    }

}
