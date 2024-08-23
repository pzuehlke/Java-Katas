public class Gambler {
    /**
     * Simulates a gambler's ruin problem and returns the number of wins and the
     * average number of bets per trial.
     *
     * @param stake  the initial amount of money the gambler starts with.
     * @param goal   the goal amount of money the gambler aims to reach.
     * @param trials the number of trials to simulate.
     * @return an array where the first element is the number of wins and the
     *         second element is the average number of bets per trial.
     */
    public static int[] simulate(int stake, int goal, int trials) {
        int bets = 0;
        int wins = 0;
        int[] result = new int[2];
        
        for (int t = 0; t < trials; t++) {
            int cash = stake;
            
            while (cash > 0 && cash < goal) {
                bets++;
                if (Math.random() > 0.5) {
                    cash++;
                } else {
                    cash--;
                }
            }
            
            if (cash == goal) {
                wins++;
            }
        }
        
        result[0] = wins;
        result[1] = bets / trials;
        
        return result;
    }

    /**
     * Entry point.
     * 
     * @param args None expected.
     */
    public static void main(String[] args) {
        int stake = Integer.parseInt(args[0]);      // e.g. 10
        int goal = Integer.parseInt(args[1]);       // e.g. 20
        int trials = Integer.parseInt(args[2]);     // e.g. 10_000
        
        int[] result = Gambler.simulate(stake, goal, trials);

        System.out.println("Wins: " + result[0]);
        System.out.println("Average bets per trial: " + result[1]);
    }
}