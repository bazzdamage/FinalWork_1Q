package gb.finalwork.animals;

import java.util.Date;
import java.util.HashSet;

public class Animal {

    HashSet<String> commands;
    String name;
    Date birthdate;

    public Animal(String name) {
        this.name = name;
        this.commands = new HashSet<>();
    }

    public Animal(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.commands = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean learnCommand(String command) {
        if (this.commands.contains(command)) {
            System.out.println(this.name + " already learn that command");
            return false;
        } else {
            this.commands.add(command);
            System.out.println(this.name + " successfully learn to " + command);
            return true;
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
            return this.name + "\nborn " + this.birthdate;
        }
    }
}
