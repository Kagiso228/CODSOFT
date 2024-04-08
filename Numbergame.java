import java.util.Scanner;
import java.util.Random;

public class Numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int attemptsLimit = 5;
        int rounds = 0;
        int Score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int secretNumber = random.nextInt(100+1); //generate a random number from 1 to 100
            int attempts = 0;
            System.out.println(secretNumber);
            System.out.println("Hey Buddy :) Guess a number between 1 and 100 (inclusive)");
            System.out.println("You have " + attemptsLimit + " attempts to guess it.");

            while (attempts < attemptsLimit) {
                long startTime = System.currentTimeMillis();

                System.out.println("Enter your guess (or 'done' to quit): ");
                String guessed_Num = scanner.nextLine();

                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;

                if (guessed_Num.equalsIgnoreCase("done")) {
                    System.out.println("Thanks for playing!");
                    System.out.println("Your total score is: " + Score);
                    return;
                }

                try {
                    int guess = Integer.parseInt(guessed_Num);
                    attempts++;

                    if (guess < secretNumber) {
                        System.out.println("Too low! Try again.");
                        System.out.println("You're left with "+ (5-attempts)+" attempts"); //prints attempts left
                    } else if (guess > secretNumber) {
                        System.out.println("Too high! Try again.");
                        System.out.println("You're left with "+ (5-attempts)+" attempts");
                    } else {
                        System.out.println("Congratulations! You've guessed the correct number " + secretNumber);
                        double time_in_sec= ((double)elapsedTime)/1000;
                        System.out.printf("You have guessed the correct answer in % .2f Seconds\n",time_in_sec); //print how long it took to guess a correct
                        Score++; //increment the score after every win
                        rounds++;
                        break;

                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }

            if (attempts >= attemptsLimit) {
                System.out.println("Sorry, you've reached the maximum number of attempts.");
                System.out.println("The correct number was: " + secretNumber);
                rounds++;
            }

            System.out.println("\nDo you want to play another round? (yes/no): ");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Thank you for playing! You have "+ Score+" wins out of " + rounds + " round(s) played" );
                return;
            }

            }
        }
    }

