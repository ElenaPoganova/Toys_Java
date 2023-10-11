package Toys.Toy;
public class Toy {
    int id;
    String name;
    int count;
    int weight;

    public String info() {
        return "Toy.info : " +
                "id = " + this.getId() +
                " name = " + this.getName() +
                " count = " + this.getCount() +
                " weight " + this.getWeight();
    }

    public Toy() {
    }

    public Toy(int id, String name, int count, int weight) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}