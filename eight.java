package task2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class eight  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your text:");
        String text = scanner.nextLine();
        
        // Convert the text to lowercase and split into words
        String[] words = text.toLowerCase().split("\\W+");

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
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}


