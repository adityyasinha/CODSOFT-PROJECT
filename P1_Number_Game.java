import java.util.Random;
import java.util.Scanner;

public class P1_Number_Game{
     static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static int hardHighScore = Integer.MAX_VALUE;
     static int easyHighScore = Integer.MAX_VALUE;
    static int mediumHighScore = Integer.MAX_VALUE;

public static void main(String[] args) {
    System.out.println("\n 🎉 Bonjour Challenger, to the fantastic guessing game!");

     boolean playAgain = true;

        while (playAgain){
            playGame();

            String response;
            do{
                 System.out.print("\n Do you like to test your luck again in next game? (yes/no):");
                response = scanner.next().trim().toLowerCase();
            } while (!response.equals("yes") && !response.equals("no"));

            playAgain = response.equals("yes");
        }
         System.out.println("\n🎯 Can you make a new high score ? We'll be waiting for your highscore... ");
    }
            
        static void playGame(){
            int max = 100;
            int min = 1;

              Difficulty difficulty = selectDifficulty();
        int maxAttempts = difficulty.maxAttempts;
        String difficultyName = difficulty.name;

        int targetNumber = random.nextInt(max - min + 1) + min;
        int attempts = 0;
        boolean guessedCorrectly = false;

         System.out.println("\n🔢 I've choosed a secret number b/w " + min + " and " + max + ". Can you find it?" );
        System.out.println("🧠 Difficulty: " + difficultyName + " | 🎯 Attempts allowed: " + maxAttempts + "\n");

  while (attempts < maxAttempts) {
            int guess = getValidatedGuess(min, max);
            attempts++;

            System.out.println("🕒 Attempt " + attempts + " of " + maxAttempts);

            if (guess == targetNumber) {
                guessedCorrectly = true;
                System.out.println("✅ Correct! You have guessed the correct number in " + attempts + " attempts.");

                updateHighScore(difficultyName, attempts);
                break;
            } else if (guess < targetNumber) {
                System.out.println("📉 Very low! Try again.\n");
            } else {
                System.out.println("📈 Very high! Try again.\n");
            }
        }

        if (!guessedCorrectly) {
            System.out.println(" Sorry 😔! You don't have more attempts. The actual secret number was: " + targetNumber);
        }
showHighScores();
    }    
    

 static int getValidInteger() {
        while (!scanner.hasNextInt()) {
            System.out.print("🎮 Invalid move! Please enter any number to keep playing: ");
            scanner.next(); // discard invalid input
        }
        return scanner.nextInt();
    }

    static int getValidatedGuess(int min, int max) {
        int guess;
        do {
            System.out.print(" It's Your move! Enter any number (" + min + "–" + max + "): ");
            guess = getValidInteger();
            if (guess < min || guess > max) {
                System.out.println("The number is out of range! Please pick a number between " + min + " and " + max + ".");
            }
        } while (guess < min || guess > max);
        return guess;
    }

    static class Difficulty {
        String name;
        int maxAttempts;

        Difficulty(String name, int maxAttempts) {
            this.name = name;
            this.maxAttempts = maxAttempts;
        }
    }

 static Difficulty selectDifficulty() {
        System.out.println("\n Choose a difficulty level:");
        System.out.println("1. Easy   (45 attempts)");
        System.out.println("2. Medium (30 attempts)");
        System.out.println("3. Hard   (20 attempts)");

        while (true) {
            System.out.print("\nEnter 1, 2, or 3: ");
            int choice = getValidInteger();

            switch (choice) {
                case 1: return new Difficulty("Easy", 45);
                case 2: return new Difficulty("Medium", 30);
                case 3: return new Difficulty("Hard", 20);
                default:
                    System.out.println("Your choice is invalid. Please select 1, 2, or 3.");
            }
        }
    }
 static void updateHighScore(String difficulty, int attempts) {
        switch (difficulty) {
            case "Easy":
                if (attempts < easyHighScore) {
                    easyHighScore = attempts;
                    System.out.println("🥉 Congratulations! You made a new high score in easy difficulty: " + easyHighScore + " attempts!");
                } else {
                    System.out.println("🥉 Easy High Score: " + easyHighScore + " attempts.");
                }
                break;
            case "Medium":
                if (attempts < mediumHighScore) {
                    mediumHighScore = attempts;
                    System.out.println(" 🥈 New Medium difficulty High Score: " + mediumHighScore + " attempts!");
                } else {
                    System.out.println("🥈 Medium High Score: " + mediumHighScore + " attempts.");
                }
                break;
            case "Hard":
                if (attempts < hardHighScore) {
                    hardHighScore = attempts;
                    System.out.println("🥇 New Hard difficulty High Score: " + hardHighScore + " attempts!");
                } else {
                    System.out.println("🥇 Hard High Score: " + hardHighScore + " attempts.");
                }
                break;
            }
        }
       

     static void showHighScores() {
        System.out.println("\n📊Your Current High Scores:");
        System.out.println("Easy   : " + (easyHighScore == Integer.MAX_VALUE ? "N/A" : easyHighScore + " attempts"));
        System.out.println("Medium : " + (mediumHighScore == Integer.MAX_VALUE ? "N/A" : mediumHighScore + " attempts"));
        System.out.println("Hard   : " + (hardHighScore == Integer.MAX_VALUE ? "N/A" : hardHighScore + " attempts"));
    }
}







