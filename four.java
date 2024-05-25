import java.util.*;
import java.util.Scanner;
public class four {
    public static void main(String[] args) {
        Random random = new Random();
        
        Scanner scanner = new Scanner(System.in);
        
        int min = 1;
        int max = 100;
        int randomNumber;
        int userGuess = 0;
        
        while (true) {
            randomNumber = random.nextInt(max - min + 1) + min;
            
            System.out.println("A new number has been generated!");
            
            while (userGuess != randomNumber) {
                System.out.println("Guess a number between " + min + " and " + max + ": ");
                
                userGuess = scanner.nextInt();
                
                if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                }
            }
            
            System.out.println("Do you want to play again? (yes/no)");
            String playAgain = scanner.next();
            
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            } else {
                userGuess = 0;
            }
        }
        
        scanner.close();
    }
}



