import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class ProductReader {

    /**
     * Reads products from a CSV file and displays their information.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
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

                if (fields.length != 4) {
                    System.out.println("Invalid record: " + line);
                    return;
                }

                String ID = fields[0].trim();
                String name = fields[1].trim();
                String description = fields[2].trim();
                double cost = Double.parseDouble(fields[3].trim());

                Product product = new Product(name, description, ID, cost);
                products.add(product);
            }

            System.out.printf("%-10s %-15s %-30s %10s%n",
                    "ID#", "Name", "Description", "Cost");
            System.out.println(
                    "--------------------------------------------------------------------");

            for (Product product : products) {
                System.out.printf("%-10s %-15s %-30s %10.2f%n",
                        product.getID(),
                        product.getName(),
                        product.getDescription(),
                        product.getCost());
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid product data: " + e.getMessage());
        }
    }
}