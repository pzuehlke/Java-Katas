public class DragonCurveInstructions {

    /**
     * Generates the instructions for drawing the Dragon Curve of order n.
     *
     * @param n the order of the Dragon Curve, must be a positive integer.
     * @return the string of instructions to draw the Dragon Curve.
     * @throws IllegalArgumentException if n is less than 1.
     */
    public String getInstructions(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(
                "The order of the curve should be a positive integer!");
        }
        String current = "F";
        for (int i = 2; i <= n; i++) {
            String replaced;
            replaced = current.replace('L', 'X');
            replaced = replaced.replace('R', 'L');
            replaced = replaced.replace('X', 'R');

            String reversedAndReplaced = new StringBuilder(replaced)
                .reverse().toString();
            
            current = current + "L" + reversedAndReplaced;
        }
        return current;
    }

    /**
     * Prints the Dragon Curve instructions for a given order from the CL.
     *
     * @param args command-line arguments; args[0] should be >= 1.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide exactly one argument for the " +
                "order n.");
            return;
        }

        try {
            int n = Integer.parseInt(args[0]);
            DragonCurveInstructions dragonCurve = new DragonCurveInstructions();
            String instructions = dragonCurve.getInstructions(n);
            System.out.println("Dragon Curve of order " + n + ": " + 
                instructions);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "The input should be an integer!", e);
        }
    }
}