package gb.finalwork.Menu;

import java.util.Scanner;

public class UserInput {

    public int selectMenuEntry(int menuSize) {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Enter a menu entry number to execute");
            sc.next();
        }
        return Math.min(sc.nextInt(), menuSize);
    }

}
