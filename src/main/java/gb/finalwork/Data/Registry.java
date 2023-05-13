package gb.finalwork.Data;

import gb.finalwork.animals.Animal;
import gb.finalwork.backend.Counter;

import java.util.HashSet;

public class Registry {

    HashSet<Animal> registry;
    Counter counter = new Counter();

    public Registry() {
        this.registry = new HashSet<>();
    }

    public HashSet<Animal> getRegistry() {
        return registry;
    }

    public void addEntry(Animal animal) {
        if (isEntryAdded(animal)) {
            counter.countIncrease();
        }
    }

    public void deleteEntry(Animal animal) {
        if (registry.remove(animal)) {
            System.out.println(animal.getName() + " has removed from registry");
        }
    }

    private boolean isEntryAdded(Animal animal) {
        if (this.registry.contains(animal)) {
            System.out.println(animal.getName() + " already have entry in registry");
            return false;
        } else {
            this.registry.add(animal);

            System.out.println(animal.getName() + " successfully added entry in registry");
            return true;
        }
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
        } else {
            System.out.println("Unknown entry");
        }
    }
}
