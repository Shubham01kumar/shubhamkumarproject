import java.util.Random;
import java.util.Scanner;
public class six {
    public static void main(String[] args) {
        Random random = new Random();
        
        Scanner scanner = new Scanner(System.in);
        
        int min = 1;
        int max = 100;
        int randomNumber;
        int userGuess;
        int maxAttempts = 10;
        
        while (true) {
            randomNumber = random.nextInt(max - min + 1) + min;
            
            System.out.println("A new number has been generated!");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");
            
            boolean guessedCorrectly = false;
            
            for (int attemptsLeft = maxAttempts; attemptsLeft > 0; attemptsLeft--) {
                System.out.println("Guess a number between " + min + " and " + max + ": ");
                
                
                userGuess = scanner.nextInt();
                
                if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                    guessedCorrectly = true;
                    break;
                }
                
                System.out.println("You have " + (attemptsLeft - 1) + " attempts left.");
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you have used all your attempts. The correct number was: " + randomNumber);
            }
            
            System.out.println("Do you want to play again? (yes/no)");
            String playAgain = scanner.next();
            
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
        
        
        scanner.close();
    }
}


