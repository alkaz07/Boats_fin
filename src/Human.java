public class Human {
    String name;
    int weight;

    public Human(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
