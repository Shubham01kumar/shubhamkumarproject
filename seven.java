package task2;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class seven {

    // Set of stop words
    private static final Set<String> STOP_WORDS = new HashSet<>();

    static { 
        String[] words = {
            "a", "an", "and", "are", "as", "at", "be", "by", "for", "if",
            "in", "is", "it", "of", "on", "or", "that", "the", "to", "was",
            "with"
            // Add more stop words as needed
        };
        for (String word : words) {
            STOP_WORDS.add(word.toLowerCase());
        }
    }

    // Method to check if a word is a stop word
    public static boolean isStopWord(String word) {
        return STOP_WORDS.contains(word.toLowerCase());
    }

    // Method to filter stop words from a given text
    public static String filterStopWords(String text) {
        String[] words = text.split("\\s+");
        List<String> filteredWords = new ArrayList<>();
        
        for (String word : words) {
            if (!isStopWord(word)) {
                filteredWords.add(word);
            }
        }
        
        return String.join(" ", filteredWords);
    }

    // Main method for testing the functionality
    public static void main(String[] args) {
        String normalText = "This is an example of a normal text with some common words.";
        String essayText = "In this essay, we discuss the impact of common words on text processing.";

        String filteredNormalText = filterStopWords(normalText);
        String filteredEssayText = filterStopWords(essayText);

        System.out.println("Filtered Normal Text: " + filteredNormalText);
        System.out.println("Filtered Essay Text: " + filteredEssayText);
    }
}



