package task2;

public class six {
    public static void main(String[] args ) {
        String[] words = {"apple", "banana", "orange", "apple", "grape", "banana", "apple"};
    
        int wordCount = 0;
    
        for (String word : words) {
             wordCount++;
        }
    
        System.out.println("Total number of words: " + wordCount);
    }
}
