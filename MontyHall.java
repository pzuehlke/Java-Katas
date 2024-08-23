import java.util.Random;

// Simulate the famous Monty Hall problem by testing the probability of winning
// following each of two strategies played several times.
public class MontyHall {

    public static boolean wonGameSwitching(Random rng) {
        int prize = rng.nextInt(3);
        int initial = rng.nextInt(3);
        return prize != initial;
    }

    public static boolean wonGameStaying(Random rng) {
        int prize = rng.nextInt(3);
        int initial = rng.nextInt(3);
        return prize == initial;
    }

    public static double[] monteCarlo(int trials) {
        int countSwitching = 0;
        int countStaying = 0;
        Random rng = new Random();
        for (int i = 0; i < trials; i++) {
            if (wonGameStaying(rng)) {
                countStaying++;
            }
            if (wonGameSwitching(rng)) {
                countSwitching++;
            }
        }
        return new double[] {(double) countStaying / trials,
                             (double) countSwitching / trials};
    }

    public static void main(String[] args) {
        int trials = Integer.parseInt(args[0]);

        double[] probs = monteCarlo(trials);
        double pStaying = probs[0];
        double pSwitching = probs[1];

        System.out.printf("Probability of winning by staying: %f\n", pStaying);
        System.out.printf("Probability of winning by switching: %f\n", pSwitching);
    }
}