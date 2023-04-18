package gb.finalwork.Menu;

public class MainMenuConstructor {

    Menu menu = new Menu();
    public MainMenuConstructor() {
        menu.addEntry(new MenuEntry("View Registry") {
            @Override
            public void run() {
                System.out.println("test1 run");
            }
        });
        menu.addEntry(new MenuEntry("Add Animal to Registry") {
            @Override
            public void run() {
                System.out.println("test2 run");
            }
        });

        menu.run();
    }




}
