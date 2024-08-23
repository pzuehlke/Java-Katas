public class Harmonic {

    /**
     * Computes the nth harmonic number.
     *
     * @param n the index of the harmonic number to be computed (>= 1).
     * @return the nth harmonic number as a double.
     */
    public static double getHarmonic(int n) {
        double sum = 0;
        for (int k = 1; k <= n; k++) {
            sum += 1.0 / k;
        }
        return sum;
    }
    public static void main(String[] args) {
        for (String arg : args) {
            int n = Integer.parseInt(arg);
            double value = getHarmonic(n);
            System.out.println(value);
        }
    }
}