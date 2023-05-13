package gb.finalwork;

import gb.finalwork.Data.Registry;
import gb.finalwork.Menu.MainMenuConstructor;
import gb.finalwork.animals.Cat;
import gb.finalwork.animals.Dog;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting...");

        Registry registry = new Registry();

        Cat pushok = new Cat("Pushok");
        Dog polkan = new Dog("Polkan");

        registry.addEntry(pushok);
        registry.addEntry(polkan);

        pushok.learnCommand("Stand");
        pushok.learnCommand("On the knees");
        polkan.learnCommand("Aport");

        registry.printRegistry();

        new MainMenuConstructor(registry);
    }
}
