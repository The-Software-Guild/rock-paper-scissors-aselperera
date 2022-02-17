package ap.rockpaperscissors;

import java.util.Scanner;

/**
 *
 * @author aselperera
 */
public class RockPaperScissors {
    public static void main(String[] args) {
        // Declare and initialise variables
        int rounds;

        // Initialise scanner
        Scanner userInput = new Scanner(System.in);

        // Prompt user for number of rounds        
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("How many rounds would you like to play? (Min: 1, Max: 10)");
        rounds = Integer.parseInt(userInput.nextLine());
        
        if (rounds >= 1 && rounds <= 10) {
            System.out.println("Valid.");
        } else {
            System.out.println("ERROR: The inputted number of rounds is invalid.");
        }
    }
}