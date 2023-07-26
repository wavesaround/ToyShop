package Toys;

public class SoftToy extends Toy{

    protected int amount;

    public SoftToy(String name, int amount, int probability) {
        super(name, probability);
        this.amount = amount;
    }

    public void giveAway(int number) {
        --this.amount;
    }

}
