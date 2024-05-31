package task2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class nine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");

        String filePath = scanner.nextLine().trim();

        // Validate input
        if (filePath.isEmpty()) {
            System.out.println("Error: File path cannot be empty.");
            scanner.close();
            return;
        }

        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append(" ");
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to read the file. " + e.getMessage());
            scanner.close();
            return;
        }

        // Validate text content
        if (text.toString().trim().isEmpty()) {
            System.out.println("Error: The file is empty or contains only whitespace.");
            scanner.close();
            return;
        }

        // Convert the text to lowercase and split into words
        String[] words = text.toString().toLowerCase().split("\\W+");

        // Create a map to store word frequencies
        Map<String, Integer> wordFrequencies = new HashMap<>();

        // Count the frequency of each word
        for (String word : words) {
            if (word.isEmpty()) continue; // Skip empty words
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }

        // Print the total number of unique words
        System.out.println("Number of unique words: " + wordFrequencies.size());

        // Print the frequency of each word
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}



