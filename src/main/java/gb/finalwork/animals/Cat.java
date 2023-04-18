package gb.finalwork.animals;

import java.util.Date;

public class Cat extends Animal{
    public Cat(String name) {
        super(name);
        System.out.println("Oh! How sweet that Kitty " + name + " is");
    }

    public Cat(String name, Date birthdate) {
        super(name, birthdate);
        System.out.println("Oh! How sweet that Kitty " + name + " is");
    }
}