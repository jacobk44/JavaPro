import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            boolean playAgain = true;

            while (playAgain) {

                Random random = new Random();
                int secretNumber = random.nextInt(100) + 1;

                int maxAttempts = 7;
                int attempts = 0;
                boolean guessedCorrectly = false;

                System.out.println("\n🎮 Welcome to Guess the Number Game!");
                System.out.println("I have chosen a number between 1 and 100.");
                System.out.println("You have " + maxAttempts + " attempts.\n");

                while (attempts < maxAttempts) {

                    System.out.print("Enter your guess: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Please enter a valid number!");
                        scanner.next(); // clear invalid input
                        continue;
                    }

                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess == secretNumber) {
                        System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts.");
                        guessedCorrectly = true;
                        break;
                    } 
                    else if (guess < secretNumber) {
                        System.out.println("📉 Too low!");
                    } 
                    else {
                        System.out.println("📈 Too high!");
                    }

                    System.out.println("Attempts left: " + (maxAttempts - attempts) + "\n");
                }

                if (!guessedCorrectly) {
                    System.out.println("❌ Game Over! The number was " + secretNumber);
                }

                // Ask to play again
                System.out.print("\nDo you want to play again? (yes/no): ");
                String answer = scanner.next();

                if (!answer.equalsIgnoreCase("yes")) {
                    playAgain = false;
                    System.out.println("👋 Thanks for playing!");
                }
            }
        }
    }
}