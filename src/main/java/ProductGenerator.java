import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {
    public static void main(String[] args) {
        ArrayList<Product> productRecords = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String ID = SafeInput.getNonZeroLenString(scanner, "Enter ID");
            String name = SafeInput.getNonZeroLenString(scanner, "Enter Name");
            String description = SafeInput.getNonZeroLenString(scanner, "Enter Description");
            double cost = SafeInput.getDouble(scanner, "Enter Cost");

            Product product = new Product(name, description, ID, cost);
            productRecords.add(product);

            boolean continueInput = SafeInput.getYNConfirm(scanner, "Do you want to add another product? (Y/N)");
            if (!continueInput) {
                break;
            }
        }

        String fileName = "ProductTestData.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Product product : productRecords) {
                writer.write(product.toCSVDataRecord());
                writer.newLine();
            }
            System.out.println("Records saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the records.");
            e.printStackTrace();
        }

        scanner.close();
    }
}