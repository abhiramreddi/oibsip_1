import java.util.Random;
import java.util.Scanner;

class Game {

    //class properties
    int sysInput;
    int userInput;
    int numberOfGuesses = 0;

    //constructor
    Game() {
        Random random = new Random();
        this.sysInput = random.nextInt(100) + 1;
    }

    public boolean takeUserInput() {
        if (numberOfGuesses < 10) {
            System.out.println("Guess the number : ");
            this.userInput = GuessTheNumber.takeIntegerInput(100);
            numberOfGuesses++;
            return false;
        } else {
            System.out.println("Number of attempts finished.. better luck next time \n");
            return true;
        }
    }

    public boolean isCorrectGuess() {
        if (sysInput == userInput) {
            System.out.println("Congratulations, you guessed the number correctly, in " + numberOfGuesses + " guesses");
            System.out.println("Your score is " + (100 - (numberOfGuesses - 1) * 10));
            System.out.println();
            return true;
        } else if (userInput > sysInput) {
            System.out.println("try lesser values");
        } else {
            System.out.println("try higher values");
        }

        return false;
    }

}

public class GuessTheNumber {
    public static void main(String[] args) {

        System.out.println("********** Guess the Number **********");
        System.out.println("1. Start the game \n2. Exit the game");
        System.out.print("Enter your choice : ");
        int choice = takeIntegerInput(2);
        int nextRound;
        int numberOfRounds = 0;
        if (choice == 1) {
            while (true) {
                Game game = new Game();
                boolean isMatched = false;
                boolean isLimitedCross = false;
                System.out.println("\nRound " + ++numberOfRounds + " starts!");
                while (!isMatched && !isLimitedCross) {
                    isLimitedCross = game.takeUserInput();
                    isMatched = game.isCorrectGuess();

                }

                System.out.println("1. NextRound \n2. Exit");
                System.out.println("Enter your choice : ");
                nextRound = takeIntegerInput(2);
                if (nextRound != 1) {
                    System.exit(0);
                }
            }

        } else {
            System.exit(0);
        }

    }

    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
                flag = true;

                if (input > limit || input < 1) {
                    System.out.print("Try again! Enter the number (1 or " + limit + ") : ");
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer values : ");
                flag = false;
            }
        }

        return input;
    }
}