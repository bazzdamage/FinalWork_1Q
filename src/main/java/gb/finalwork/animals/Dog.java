package gb.finalwork.animals;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name) {
        super(name);
        System.out.println("So! That dog " + name + " is awesome!!!");
    }
}
