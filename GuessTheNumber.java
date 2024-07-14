import java.util.*;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean keepPlaying = true;
        int totalScore = 0;
        int round = 1;

        while (keepPlaying) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean numberGuessed = false;
            System.out.println("Round " + round + ":");
            System.out.println("Guess the number between 1 and 100. You have 10 attempts.");

            while (attempts < 10) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    numberGuessed = true;
                    int points = 10 - attempts + 1; // More points for fewer attempts
                    totalScore += points;
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    System.out.println("You earned " + points + " points. Total score: " + totalScore);
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("The number is higher. Try again.");
                } else {
                    System.out.println("The number is lower. Try again.");
                }
            }

            if (!numberGuessed) {
                System.out.println("You've used all 10 attempts. The number was: " + numberToGuess);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = sc.next();
            keepPlaying = response.equalsIgnoreCase("yes");
            if (keepPlaying) {
                round++;
            }
        }

        System.out.println("Game over. Your total score: " + totalScore);
        sc.close();
    }
}
