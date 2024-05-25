import java.util.Random;
import java.util.Scanner;
public class two {
    public static void main(String[] args) {
        Random random = new Random();
        
        Scanner scanner = new Scanner(System.in);
        
        int min = 1;
        int max = 100;
        
        int randomNumber = random.nextInt(max - min + 1) + min;
        
        System.out.println("Guess a number between " + min + " and " + max + ": ");
        
        int userGuess = scanner.nextInt();
        
        if (userGuess == randomNumber) {
            System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
        } else {
            System.out.println("Sorry, the correct number was: " + randomNumber);
        }
        
        scanner.close();
    }
}


