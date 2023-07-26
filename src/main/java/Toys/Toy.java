package Toys;

public abstract class Toy {

    protected static int id = 0;
    protected String name;
    protected int amount;
    protected int probability;
    protected String state;
    protected String manufacture;

    public Toy(String name, int amount, int probability) {
        Toy.id++;
        this.name = name;
        this.amount = amount;
        this.probability = probability;
        manufacture = "China";
        state = "new";
    }

    @Override
    public String toString() {
        return name + ':' +
                " ID=" + id +
                ", class='" + this.getClass().getSimpleName() + '\'' +
                ", probability=" + probability +
                ", amount=" + amount +
                ", manufacture='" + manufacture + '\'' +
                ", state='" + state + '\''
                ;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
