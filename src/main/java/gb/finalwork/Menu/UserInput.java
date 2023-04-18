package gb.finalwork.Menu;

import gb.finalwork.animals.Animal;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class UserInput {

    public int selectMenuEntry(int menuSize) {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Enter a menu entry number to execute");
            sc.next();
        }
        return Math.min(sc.nextInt(), menuSize);
    }

    public Animal inputAnimalInfo (Animal animal) {
        String dateformat = "dd/MM/uuuu";
        DateTimeFormatter f = DateTimeFormatter.ofPattern (dateformat);

        System.out.println("Please enter the name of Pet");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext()) {
            System.out.println("Name must be not empty");
            sc.next();
        }
        String name = sc.nextLine();
        System.out.println("Please enter the Date of Birth in format " + dateformat + " ...for Example - " + LocalDate.now().format(f));
        LocalDate dateOfBirth = LocalDate.now();
        while (!isDateCorrect(sc.next(), f)) {
            System.out.println("Date must be BEFORE NOW and formatted " + dateformat + " ...for Example - " + dateOfBirth.format(f));
            dateOfBirth = LocalDate.parse(sc.nextLine());
        }
        animal.setName(name);
        animal.setBirthdate(dateOfBirth);
        return animal;
    }

    private boolean isDateCorrect(String dateString, DateTimeFormatter f) {

        try {
            LocalDate ld = LocalDate.parse(dateString, f);
            return ld.isBefore(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
