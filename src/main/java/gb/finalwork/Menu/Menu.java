package gb.finalwork.Menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private final List<MenuEntry> entries = new ArrayList<MenuEntry>();
    private boolean isExit = false;

    public Menu() {
        // Добавляем пункт меню Exit
        entries.add(new MenuEntry("Exit") {
            @Override
            public void run() {
                isExit = true;
            }
        });
    }

    public void run() {
        // Бесконечный цикл, пока не нажали кнопку выход
        while (!isExit) {
            printMenu();
            UserInput ui = new UserInput();
            int choice = ui.selectMenuEntry(entries.size());
            MenuEntry entry = entries.get(choice - 1);
            entry.run();
        }
    }

    private void printMenu() {
        for (MenuEntry entry : entries) {
            System.out.println(entry.getTitle());
        }
    }


    public void addEntry(MenuEntry entry) {
        entries.add(0, entry);
    }
}
