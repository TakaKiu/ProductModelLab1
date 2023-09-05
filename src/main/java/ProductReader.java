import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProductReader {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Product Files", "txt");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (Scanner fileScanner = new Scanner(selectedFile)) {
                System.out.println("Displaying records from: " + selectedFile.getName());
                System.out.println();

                displayHeader();
                displayHeaderSeparator();

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    displayFormattedRecord(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + selectedFile.getName());
            }
        }
    }

    public static void displayHeader() {
        System.out.printf("%-10s%-20s%-25s%-10s\n", "ID", "Name", "Description", "Cost");
    }

    public static void displayHeaderSeparator() {
        System.out.println("===================================================");
    }

    public static void displayFormattedRecord(String record) {
        String[] data = record.split(", ");
        if (data.length == 4) {
            System.out.printf("%-10s%-20s%-25s%-10s\n", data[0], data[1], data[2], data[3]);
        } else {
            System.out.println("Invalid record format: " + record);
        }
    }
}