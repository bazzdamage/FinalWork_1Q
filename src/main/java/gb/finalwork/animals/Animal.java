package gb.finalwork.animals;

import gb.finalwork.backend.Counter;

import java.time.LocalDate;
import java.util.HashSet;

public class Animal {

    HashSet<String> commands;
    String name;
    LocalDate birthdate;
    Integer count;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
        this.birthdate = LocalDate.now();
        this.commands = new HashSet<>();
    }

    public Animal(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.commands = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public HashSet<String> getCommands() {
        return commands;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
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
