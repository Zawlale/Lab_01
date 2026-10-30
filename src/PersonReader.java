import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class PersonReader {

    /**
     * Reads people from a CSV file and displays their information.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new java.io.File("."));

        if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            System.out.println("No file selected.");
            return;
        }

        Path file = chooser.getSelectedFile().toPath();

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] fields = line.split(",", -1);

                if (fields.length != 5) {
                    System.out.println("Invalid record: " + line);
                    return;
                }

                String ID = fields[0].trim();
                String firstName = fields[1].trim();
                String lastName = fields[2].trim();
                String title = fields[3].trim();
                int YOB = Integer.parseInt(fields[4].trim());

                Person person = new Person(firstName, lastName, ID, title, YOB);
                people.add(person);
            }

            System.out.printf("%-10s %-15s %-15s %-10s %-6s%n",
                    "ID#", "First Name", "Last Name", "Title", "YOB");
            System.out.println("------------------------------------------------------------");

            for (Person person : people) {
                System.out.printf("%-10s %-15s %-15s %-10s %-6d%n",
                        person.getID(),
                        person.getFirstName(),
                        person.getLastName(),
                        person.getTitle(),
                        person.getYOB());
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid person data: " + e.getMessage());
        }
    }
}