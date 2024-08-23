public class EulersConjecture {

/**
 * Searches for counterexamples to Euler's sum-of-powers conjecture, which
 * asserts that at least n n-th powers are required to obtain a sum
 * that is itself an n-th power, for n > 2.
 * 
 * Specifically, we check for solutions to the equation
 * a^5 + b^5 + c^5 + d^5 = e^5, where a, b, c, d, and e are
 * distinct positive integers less than a specified limit.
 * 
 * @param args args[0] is the upper bound for the value of `e`.
 */
    public static void main(String[] args) {
        int limit = Integer.parseInt(args[0]);

        for (long a = 1; a < limit; a++) {
            long a5 = a * a * a * a * a;
            for (long b = a; b < limit; b++) {
                long b5 = b * b * b * b * b;
                for (long c = b; c < limit; c++) {
                    long c5 = c * c * c * c * c;
                    for (long d = c; d < limit; d++) {
                        long d5 = d * d * d * d * d;
                        for (long e = d + 1; e <= limit; e++) {
                            long e5 = e * e * e * e * e;

                            if (a5 + b5 + c5 + d5 == e5) {
                                System.out.printf("Found: %d^5 + %d^5 + %d^5 + %d^5 = %d^5%n", a, b, c, d, e);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}