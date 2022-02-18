package ap.rockpaperscissors;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author aselperera
 */
public class RockPaperScissors {
    public static void main(String[] args) {
        // Declare and initialise variables
        int rounds, userChoiceInt, aiChoiceInt, userWins = 0, aiWins = 0, ties = 0;
        String userChoice;
        String[] choices = {"rock", "paper", "scissors"};
        boolean keepPlaying = true;
        
        // Initialise random number generator
        Random rng = new Random();

        // Initialise scanner
        Scanner userInput = new Scanner(System.in);

        // Prompt user for number of rounds
        System.out.println("Welcome to Rock, Paper, Scissors!");
        
        do {
            System.out.println("How many rounds would you like to play? (Min: 1, Max: 10)");
            rounds = Integer.parseInt(userInput.nextLine());

            // Add check for integer
            if (rounds >= 1 && rounds <= 10) {

                for (int i = 0; i < rounds; i++) {
                    // Ask user for rock, paper or scissors
                    // Check for capitalisation, or any other options
                    System.out.println("Which do you choose: rock, paper or scissors?");
                    userChoice = userInput.nextLine().toLowerCase();
                    userChoiceInt = Arrays.asList(choices).indexOf(userChoice);

                    // Generate random number
                    aiChoiceInt = rng.nextInt(3);
                    System.out.println("I pick " + choices[aiChoiceInt]);

                    // Check for winner
                    if ((userChoiceInt - aiChoiceInt) % 3 == 1) {
                        userWins++;
                        System.out.println("You win this round.");
                    } else if (userChoiceInt == aiChoiceInt) {
                        ties++;
                        System.out.println("Looks like it's a tie.");
                    } else {
                        aiWins++;
                        System.out.println("I win this round!");
                    }
                    System.out.println("User wins: " + userWins + ", AI wins: " + aiWins + ", Ties: " + ties + "\n");
                }

                // Determine final winner
                if (userWins > aiWins) {
                    System.out.println("Looks like you won. Congratulations!");
                } else if (userWins < aiWins) {
                    System.out.println("Looks like I won. Thanks for playing.");
                } else {
                    System.out.println("Looks like it's a tie overall.");
                }

                // Determine whether to play again
                System.out.println("Would you like to play again?");
                userChoice = userInput.nextLine().toLowerCase();
                switch (userChoice) {
                    case "yes":
                        userWins = 0;
                        aiWins = 0;
                        ties = 0;
                        break;
                    case "no":
                        keepPlaying = false;
                        break;
                    default:
                        keepPlaying = false;
                }

            } else {
                System.out.println("ERROR: The inputted number of rounds is invalid.");
                keepPlaying = false;
            }
        } while (keepPlaying);
    }
}