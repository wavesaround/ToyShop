package Toys;

public class SoftToy extends Toy{

    protected String color;
    protected int amount;

    public SoftToy(String name, int amount, int probability) {
        super(name, probability);
        this.color = "Blue";
        this.amount = amount;
    }

    public void giveAway(int number) {
        --this.amount;
    }

}
