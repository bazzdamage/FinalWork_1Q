package gb.finalwork.Data;

import gb.finalwork.animals.Animal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Registry {

    HashSet<Animal> registry;

    public HashSet<Animal> getRegistry() {
        return registry;
    }

    public Registry() {
        this.registry = new HashSet<>();
    }

    public boolean addEntry(Animal animal) {
        if (this.registry.contains(animal)) {
            System.out.println(animal.getName() + " already have entry in registry");
            return false;
        } else {
            this.registry.add(animal);

            System.out.println(animal.getName() + " successfully added entry in registry");
            return true;
        }
    }

    public int getSize() {
        return registry.size();
    }

    public void printRegistry() {
        if (this.registry.size() == 0) {
            System.out.println("Registry has not entries yet");
        } else {
            int count = 1;
            System.out.println("Registry have a total " + registry.size() + " entries:\n");
            for (Animal entry : registry) {
                System.out.println(count + ". " + entry);
                count++;
            }
        }
        System.out.println("END OF REGISTRY");
    }

    public void printEntry(Animal animal) {
        if (this.registry.contains(animal)) {
            System.out.println(animal.toString());
            animal.printCommands();
        } else {
            System.out.println("Unknown entry");
        }
    }
}
