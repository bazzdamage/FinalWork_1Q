package gb.finalwork.Menu;

import gb.finalwork.Data.Registry;
import gb.finalwork.animals.Animal;
import gb.finalwork.animals.Cat;
import gb.finalwork.animals.Dog;

public class MainMenuConstructor {

    Menu menu = new Menu();

    public MainMenuConstructor(Registry registry) {
        menu.addEntry(new MenuEntry("View Registry") {
            @Override
            public void run() {
                viewRegistry(registry);
            }
        });
        menu.addEntry(new MenuEntry("Add Animal to Registry") {
            @Override
            public void run() {
                addAnimal(registry);
            }
        });

        menu.run();
    }

    private void addAnimal(Registry registry) {
        UserInput ui = new UserInput();
        Menu addAnimal = new Menu();
        addAnimal.addEntry(new MenuEntry("Cat") {
            @Override
            public void run() {
                registry.addEntry(ui.inputAnimalInfo(new Cat()));
            }
        });
        addAnimal.addEntry(new MenuEntry("Dog") {
            @Override
            public void run() {
                registry.addEntry(ui.inputAnimalInfo(new Dog()));
            }
        });
        addAnimal.run();
        menu.run();
    }

    private void viewRegistry(Registry registry) {
        UserInput ui = new UserInput();
        Menu viewRegistry = new Menu();
        for (Animal animal : registry.getRegistry()) {
            viewRegistry.addEntry(new MenuEntry(animal.toString()) {
                @Override
                public void run() {
                    registry.printEntry(animal);
                }
            });
        }
        viewRegistry.run();
        menu.run();
    }
}
