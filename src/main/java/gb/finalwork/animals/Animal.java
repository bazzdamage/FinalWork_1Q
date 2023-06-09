package gb.finalwork.animals;

import java.time.LocalDate;
import java.util.HashSet;

public class Animal {

    HashSet<String> commands = new HashSet<>();
    String name;
    LocalDate birthdate;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
        this.birthdate = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void learnCommand(String command) {
        if (this.commands.contains(command)) {
            System.out.println(this.name + " already learn that command");
        } else {
            this.commands.add(command);
            System.out.println(this.name + " successfully learn to " + command);
        }
    }

    public void printCommands() {
        if (this.commands == null) {
            System.out.println(this.name + " has not learned any command yet");
        } else {
            System.out.println(this.name + " already learned this commands:");
            for (String command : commands) {
                System.out.println(command);
            }
        }
    }

    @Override
    public String toString() {
        if (this.birthdate == null) {
            return this.name;
        } else {
            return this.name + " born " + this.birthdate;
        }
    }
}
