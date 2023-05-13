package gb.finalwork.animals;

public class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name) {
        super(name);
        System.out.println("Oh! How sweet that Kitty " + name + " is");
    }
}
