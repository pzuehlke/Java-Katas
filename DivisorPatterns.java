public class DivisorPatterns {

    /**
     * Prints a visual * pattern of divisors from 1 to a given number.
     * 
     * Example output for n = 4:
     *  1: * 
     *  2: * * 
     *  3: *   * 
     *  4: * *   *
     *
     * @param n the upper bound of the range for which the patterns are printed.
     */   
    public static void printDivisorPatterns(int n) {
            System.out.println();
            for (int i = 1; i <= n; i++) {
                System.out.printf("%3d: ", i);
                for (int d = 1; d <= i; d++) {
                    if (i % d == 0) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        printDivisorPatterns(n);
        return;
    }
}