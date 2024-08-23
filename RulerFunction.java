public class RulerFunction {

    /** 
     * Generates a ruler sequence as a string for the given integer n.
     * 
     * @param n the highest number in the ruler sequence.
     * @return the ruler sequence as a string.
     */
    public static String getRuler(int n) {
        String ruler = "";

        for (int i = 1; i <= n; i++) {
            ruler = ruler + i + ruler;
        }
        return ruler;
    }

    /**
     * Entry point.
     *
     * @param args command-line arguments; args[0] should be an integer n.
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String ruler = getRuler(n);
        int length = ruler.length();

        System.out.println();
        for (int height = n; height > 0; height--) {
            for (int i = 0; i < length; i++) {
                int mark = ruler.charAt(i) - '0';
                if (mark >= height) {
                    System.out.print("|" + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}