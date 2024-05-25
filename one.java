import java.util.Random;
public class one {
    public static void main(String[] args) {
    
        Random random = new Random();

        int min = 1;
        int max = 100;

        int randomNumber = random.nextInt(max - min + 1) + min;
        System.out.println("Random number between " + min + " and " + max + ": " + randomNumber);
    }
    

}
