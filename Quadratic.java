public class Quadratic {

    /**
     * Computes the real roots of the quadratic equation ax^2 + bx + c = 0.
     *
     * @param a the coefficient of the quadratic term (x^2).
     * @param b the coefficient of the linear term (x).
     * @param c the constant term.
     * @return a double array containing the two real roots of the equation.
     * @throws IllegalArgumentException if a == 0 or the eq. has no real roots.
     */
    public static double[] findRoots(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("Coefficient 'a' " +
                "cannot be zero!");
        }

        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            throw new IllegalArgumentException("The equation " + 
                "has no real roots!");
        }

        double sqrtDelta = Math.sqrt(delta);
        double x1 = (-b + sqrtDelta) / (2 * a);
        double x2 = (-b - sqrtDelta) / (2 * a);

        return new double[]{x1, x2};
    }

    /**
     * @param args CLI arguments containing the coefficients a, b, and c.
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please provide the coefficients a, b, c.");
            return;
        }

        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        double[] roots = findRoots(a, b, c);

        System.out.println("1st root: " + roots[0]);
        System.out.println("2nd root: " + roots[1]);
    }
}
