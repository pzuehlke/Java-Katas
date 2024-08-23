import java.util.ArrayList;

/**
 * Finds and displays the prime factors of a given integer.
 *
 * @param n the integer to be factored into its prime components.
 * @return an ArrayList containing the prime factors of the integer n.
 */

public class Factors {
    public static ArrayList<Integer> findFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<>();

        for (int d = 2; n > 1; d++) {
            while (n % d == 0) {
                factors.add(d);
                n /= d;
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        ArrayList<Integer> factors = findFactors(n);
        System.out.println("The factors of " + n + " are:");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();
    }
}