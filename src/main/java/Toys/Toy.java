package Toys;

public abstract class Toy {

    protected static int id = 0;
    protected String name;
    protected int probability;
    protected String state;
    protected String manufacture;

    public Toy(String name, int probability) {
        Toy.id++;
        this.name = name;
        this.probability = probability;
        manufacture = "China";
        state = "new";
    }

    @Override
    public String toString() {
        return name + ':' +
                " class='" + this.getClass().getSimpleName() + '\'' +
                ", probability=" + probability +
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

}
