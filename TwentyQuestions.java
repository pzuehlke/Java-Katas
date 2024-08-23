// Requires java-introcs library.
public class TwentyQuestions {

    /**
     * A simple guessing game where the player tries to guess a randomly generated 
     * number between 1 and 1,000,000.
     *
     * The program repeatedly prompts the user for guesses and provides feedback 
     * indicating whether the guess was too low, too high, or correct.
     */
    public static void main(String[] args) {
        int secret = 1 + (int) (Math.random() * 1_000_000);
        System.out.print("I'm thinking of a number ");
        System.out.print("between 1 and 1,000,000. ");
        int guess = 0;
        while (guess != secret) {
            System.out.println("What's your guess?");
            guess = StdIn.readInt();
            if (guess == secret) { System.out.println("You win!"); }
            if (guess < secret)  { System.out.println("Too low."); }
            if (guess > secret)  { System.out.println("Too high."); }
        }
    }
}
