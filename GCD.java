public class GCD {

    /**
     * Computes the greatest common divisor (GCD) of two integers.
     *
     * @param m the first integer.
     * @param n the second integer.
     * @return the greatest common divisor of the integers m and n.
     */
    public static int computeGCD(int m, int n) {
        if (n == 0) {
            return Math.abs(m);
        }
        return computeGCD(n, m % n);
    }

    public static void testComputeGCD() {
        int[][] testCases = {
            {48, 18},
            {56, 98},
            {101, 103},
            {0, 5},
            {5, 0},
            {18, 48},
            {54, 24},
            {45, -15},
            {-45, -15},
            {0, 0}
        };

        for (int[] testCase : testCases) {
            int m = testCase[0];
            int n = testCase[1];
            int gcd = computeGCD(m, n);
            System.out.println("gcd(" + m + ", " + n + ") \t= " + gcd);
        }
    }

    public static void main(String[] args) {
        testComputeGCD();
    }
}