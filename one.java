package task2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to enter text directly or provide a file? (enter/file)");

        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("enter")) {
            System.out.println("Please enter your text:");
            String text = scanner.nextLine();
            int wordCount = countWords(text);
            System.out.println("The text contains " + wordCount + " words.");
        } else if (choice.equalsIgnoreCase("file")) {
            System.out.println("Please enter the file path:");
            String filePath = scanner.nextLine();
            File file = new File(filePath);
            try {
                Scanner fileScanner = new Scanner(file);
                StringBuilder fileContent = new StringBuilder();
                while (fileScanner.hasNextLine()) {
                    fileContent.append(fileScanner.nextLine()).append(" ");
                }
                int wordCount = countWords(fileContent.toString());
                System.out.println("The file contains " + wordCount + " words.");
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please check the file path and try again.");
            }
        } else {
            System.out.println("Invalid choice. Please run the program again and enter 'enter' or 'file'.");
        }

        scanner.close();
    }

    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }
}


