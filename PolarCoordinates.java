public class PolarCoordinates {

    /**
     * Converts Cartesian coordinates (x, y) into polar coordinates (r, θ).
     *
     * @param x the x-coordinate in Cartesian coordinates.
     * @param y the y-coordinate in Cartesian coordinates.
     * @return a double array where the first element is the radius r and 
     *         the second element is the angle θ in radians.
     * @throws IllegalArgumentException if both x and y are zero.
     */
    public static double[] getPolar(double x, double y) {
        if (x == 0 && y == 0) {
            throw new IllegalArgumentException(
                "The angle is undefined at the origin (0, 0).");
        }
        double polar[] = new double[2];
        polar[0] = Math.sqrt(x * x + y * y);
        polar[1] = Math.atan2(y, x);

        return polar;
    }

    /**
     * Entry point.
     *
     * @param args args[0] and args[1] should be valid doubles
     *             representing the x and y coordinates.
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide exactly two arguments for " +
                "the x and y coordinates.");
            return;
        }

        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double[] polar = getPolar(x, y);

        System.out.println("The polar coordinates of the point" +
            " (" + x + ", " + y + ") are:\n\tradius = " + polar[0] +
            "\n\tangle = " + polar[1] + " radians");
    }
}