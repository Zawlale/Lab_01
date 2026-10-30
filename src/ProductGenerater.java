import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerater {

    /**
     * Gets product information and saves it to a CSV text file.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        boolean done;

        do {
            String ID = SafeInput.getNonZeroLenString(pipe, "Enter the ID");
            String name = SafeInput.getNonZeroLenString(pipe, "Enter the name");
            String description = SafeInput.getNonZeroLenString(
                    pipe, "Enter the description");

            double cost;

            do {
                cost = SafeInput.getDouble(pipe, "Enter the cost");

                if (cost < 0 || !Double.isFinite(cost)) {
                    System.out.println("Enter a valid cost of zero or more.");
                }
            } while (cost < 0 || !Double.isFinite(cost));

            Product product = new Product(name, description, ID, cost);
            products.add(product);

            System.out.println("Product added!");
            done = SafeInput.getYNConfirm(pipe, "Are you done?");

        } while (!done);

        String fileName = SafeInput.getNonZeroLenString(
                pipe, "Enter the file name");

        if (!fileName.endsWith(".txt")) {
            fileName += ".txt";
        }

        Path file = Path.of(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            System.out.println("\nHere are the products you entered:");

            for (Product product : products) {
                writer.write(product.toCSV());
                writer.newLine();
                System.out.println(product.toCSV());
            }

            System.out.println("\nFile saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving the file: " + e.getMessage());
        }
    }
}