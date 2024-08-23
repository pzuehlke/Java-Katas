public class Checkerboard {

    /** Prints a given number of lines in a checkerboard pattern using
     * the characters '*' and 'o'.
     * 
     * @param args args[0] is the number of lines to be generated.
     * @return Nothing.
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        System.out.println();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                System.out.printf("*o".repeat(n / 2));
                if (n % 2 == 1) {
                    System.out.printf("*");
                }
            }
            else {
                System.out.printf("o*".repeat(n / 2));
                if (n % 2 == 1) {
                    System.out.printf("o");
                }
            }
            System.out.println();
        }
    }
}