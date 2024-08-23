import java.util.Random;

public class SpherePointGenerator {

    /**
     * Generates a uniformly random point (x, y) in the unit disk.
     *
     * @return a double array containing the coordinates of the generated point.
     */
    private static double[] generateRandomPoint() {
        Random random = new Random();
        double x, y;

        do {
            x = 2 * random.nextDouble() - 1;
            y = 2 * random.nextDouble() - 1;
        } while (x * x + y * y >= 1);

        return new double[] {x, y};
    }

    /**
     * Generates a random point (a, b, c) on S^2 using Marsaglia's method.
     *
     * @return Nothing.
     */
    public static void main(String[] args) {
        double[] point = generateRandomPoint();
        double x = point[0];
        double y = point[1];

        double a = 2 * x * Math.sqrt(1 - x * x - y * y);
        double b = 2 * y * Math.sqrt(1 - x * x - y * y);
        double c = 1 - 2 * (x * x + y * y);

        System.out.printf("(a, b, c) = (%.3f, %.3f, %.3f)\n", a, b, c);
    }

}