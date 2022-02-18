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
        
        // Initialise random number generator
        Random rng = new Random();

        // Initialise scanner
        Scanner userInput = new Scanner(System.in);

        // Prompt user for number of rounds
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("How many rounds would you like to play? (Min: 1, Max: 10)");
        rounds = Integer.parseInt(userInput.nextLine());
        
        // Add check for integer
        if (rounds >= 1 && rounds <= 10) {
            
            for (int i = 0; i < rounds; i++) {
                // Ask user for rock, paper or scissors
                // Check for capitalisation, or any other options
                System.out.println("Which do you choose: rock, paper or scissors?");
                userChoice = userInput.nextLine();
                userChoiceInt = Arrays.asList(choices).indexOf(userChoice);
                
                // Generate random number
                aiChoiceInt = rng.nextInt(3);
                System.out.println("I pick " + choices[aiChoiceInt]);
                
                // Check for winner
                if ((aiChoiceInt - userChoiceInt) % 3 == 1) {
                    aiWins++;
                    System.out.println("I win this round!");
                } else if (aiChoiceInt == userChoiceInt) {
                    ties++;
                    System.out.println("Looks like it's a tie.");
                } else {
                    userWins++;
                    System.out.println("You win this round.");
                }
                System.out.println("User wins: " + userWins + ", AI wins: " + aiWins + ", Ties: " + ties + "\n");
            }

        } else {
            System.out.println("ERROR: The inputted number of rounds is invalid.");
        }
    }
}