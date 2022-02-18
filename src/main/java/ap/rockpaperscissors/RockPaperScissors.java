package ap.rockpaperscissors;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class RockPaperScissors {
    public static void main(String[] args) {
        
        // Declare and initialise variables
        int rounds, userChoiceInt, aiChoiceInt, modulus, userWins = 0, aiWins = 0, ties = 0;
        String userChoice;
        String[] choices = {"rock", "paper", "scissors"};
        boolean keepPlaying = true;
        
        // Initialise random number generator
        Random rng = new Random();

        // Initialise scanner
        Scanner userInput = new Scanner(System.in);

        // Prompt user for number of rounds
        System.out.println("Welcome to Rock, Paper, Scissors!");
        
        // Rounds
        do {
            System.out.println("How many rounds would you like to play? (Min: 1, Max: 10)");
            rounds = Integer.parseInt(userInput.nextLine());

            if (rounds >= 1 && rounds <= 10) {

                for (int i = 0; i < rounds; i++) {
                    // Ask user for rock, paper or scissors
                    System.out.println("\nWhich do you choose: rock, paper or scissors?");
                    userChoice = userInput.nextLine().toLowerCase();
                    userChoiceInt = Arrays.asList(choices).indexOf(userChoice);

                    // Generate random number
                    aiChoiceInt = rng.nextInt(3);
                    System.out.println("I pick " + choices[aiChoiceInt]);

                    // Check for winner
                    modulus = (((userChoiceInt - aiChoiceInt) % 3) + 3) % 3; // Calculation needed to get true modulus rather than remainder
                    if (modulus == 1) {
                        userWins++;
                        System.out.println("You win this round!");
                    } else if (modulus == 0) {
                        ties++;
                        System.out.println("This round is a tie.");
                    } else {
                        aiWins++;
                        System.out.println("I win this round!");
                    }
                }

                // Determine final winner
                System.out.println("\n--- FINAL RESULTS ---");
                System.out.println("User wins: " + userWins + ", AI wins: " + aiWins + ", Ties: " + ties);
                if (userWins > aiWins) {
                    System.out.println("Looks like you won. Congratulations!");
                } else if (userWins < aiWins) {
                    System.out.println("Looks like I won. Nice try!");
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
                        System.out.println(""); // Line break
                        break;
                    case "no":
                        System.out.println("Thanks for playing!");
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