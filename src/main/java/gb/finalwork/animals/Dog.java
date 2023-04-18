package gb.finalwork.animals;

import java.time.LocalDate;
import java.util.Date;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name) {
        super(name);
        System.out.println("So! That dog " + name + " is awesome!!!");
    }

    public Dog(String name, LocalDate birthdate) {
        super(name, birthdate);
        System.out.println("So! That dog " + name + " is awesome!!!");
    }

}
