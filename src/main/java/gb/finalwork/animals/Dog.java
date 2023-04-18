package gb.finalwork.animals;

import java.util.Date;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        System.out.println("So! That dog " + name + " is awesome!!!");
    }

    public Dog(String name, Date birthdate) {
        super(name, birthdate);
        System.out.println("So! That dog " + name + " is awesome!!!");
    }

}
