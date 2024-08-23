public class RGBtoCMYK {

    /**
     * Converts RGB color values to CMYK color values.
     *
     * @param r red value (0 to 255).
     * @param g green value (0 to 255).
     * @param b blue value (0 to 255).
     * @return CMYK values as a double array.
     * @throws IllegalArgumentException if an RGB value is outside 0-255.
     */
    public static double[] getCMYK(int r, int g, int b) {
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
            throw new IllegalArgumentException("RGB values " +
            "must be in the range 0 to 255.");
        }

        double rd = r / 255.0;
        double gd = g / 255.0;
        double bd = b / 255.0;

        double w = Math.max(rd, Math.max(gd, bd));
        double c = (w - rd) / w;
        double m = (w - gd) / w;
        double y = (w - bd) / w;
        double k = 1 - w;

        // Handle the case where r, g, and b are all zero:
        if (w == 0) {
            c = 0;
            m = 0;
            y = 0;
            k = 1;
        }

        return new double[]{c, m, y, k};
    }

    /**
     * @param args Arguments containing the R, G and B values, respectively.
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please provide " +
                "exactly three arguments: r, g, and b.");
            return;
        }

        try {
            int r = Integer.parseInt(args[0]);
            int g = Integer.parseInt(args[1]);
            int b = Integer.parseInt(args[2]);

            double[] cmyk = getCMYK(r, g, b);
            System.out.printf("CMYK: C=%.2f, M=%.2f, Y=%.2f, K=%.2f%n",
                cmyk[0], cmyk[1], cmyk[2], cmyk[3]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. "+ 
                "Please provide valid integers for r, g, and b.");
        }
    }
}