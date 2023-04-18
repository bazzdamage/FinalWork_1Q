package gb.finalwork.Data;

import gb.finalwork.animals.Animal;

import java.util.HashSet;

public class Registry {

    HashSet<Animal> registry;

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

    public void printRegistry() {
        if(this.registry.size() == 0) {
            System.out.println("Registry has not entries yet");
        } else {
            System.out.println("Registry have a total " + registry.size() + " entries:\n");
            for (Animal entry : registry) {
                System.out.println(entry);
                entry.printCommands();
                System.out.println(" ----------------------- ");
            }
        }
    }

}
