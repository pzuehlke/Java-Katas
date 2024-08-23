import java.util.ArrayList;

public class Eratosthenes {

    /**
     * Finds all prime numbers up to and including n
     * using the Sieve of Eratosthenes algorithm.
     *
     * @param n the upper limit for finding prime numbers.
     * @return an ArrayList of prime numbers up to and including n.
     */
    public static ArrayList<Integer> findPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int k = 0; k <= n; k++) {
            isPrime[k] = true;
        }

        isPrime[0] = isPrime[1] = false;
        for (int k = 2; k <= n; k++) {
            if (isPrime[k]) {
                int multiple = 2 * k;
                while (multiple <= n) {
                    isPrime[multiple] = false;
                    multiple += k;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int k = 2; k <= n; k++) {
            if (isPrime[k]) {
                primes.add(k);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        ArrayList<Integer> primes = findPrimes(n);
        System.out.println(
            "Prime numbers up to " + n + ":\n" + primes
        );
    }
}
