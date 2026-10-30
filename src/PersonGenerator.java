
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

public class PersonGenerator {

    public static void main(String[] args) {

        // Things we need
        Scanner in = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        boolean done = false;

        // Keep adding people until we're done
        do {

            // Get the person's information
            String id = SafeInput.getRegExString(in,
                    "Enter the ID (6 digits)", "[0-9]{6}");

            String firstName = SafeInput.getNonZeroLenString(in,
                    "Enter the first name");

            String lastName = SafeInput.getNonZeroLenString(in,
                    "Enter the last name");

            String title = SafeInput.getNonZeroLenString(in,
                    "Enter the title");

            int yearOfBirth = SafeInput.getRangedInt(in,
                    "Enter the year of birth", 1940, 2010);

            // Make a Person object
            Person person = new Person(firstName, lastName, id,
                    title, yearOfBirth);

            // Add the person to our list
            people.add(person);

            System.out.println("Person added!");

            // Ask if we're done
            done = SafeInput.getYNConfirm(in, "Are you done?");

        } while (!done);

        // Show the people we entered
        System.out.println("\nHere are the people you entered:");

        for (Person person : people) {
            System.out.println(person.toCSV());
        }

        // Let the user choose where to save
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save your person data");
        chooser.setSelectedFile(new java.io.File("PersonTestData.txt"));

        boolean saved = false;

        while (!saved) {

            if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) {
                System.out.println("File was not saved.");
                break;
            }

            Path file = chooser.getSelectedFile().toPath();

            // Save the people into the file
            try (BufferedWriter writer = Files.newBufferedWriter(file)) {

                for (Person person : people) {
                    writer.write(person.toCSV());
                    writer.newLine();
                }

                System.out.println("File saved successfully!");
                saved = true;

            } catch (IOException e) {
                System.out.println("There was a problem saving the file.");
            }
        }
    }
}
