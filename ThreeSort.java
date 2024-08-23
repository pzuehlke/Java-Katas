public class ThreeSort {

    /**
     * Sorts three integers and prints them in ascending order using
     * only two Min and Max operations.
     *
     * @param a the first integer.
     * @param b the second integer.
     * @param c the third integer.
     */
    public static void sortAndPrint(int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int mid = a + b + c - min - max;

        System.out.println("Sorted order: " + min + ", " + mid + ", " + max);
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please provide exactly " +
                "three integer arguments.");
            return;
        }

        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[2]);

            sortAndPrint(a, b, c);
        } catch (NumberFormatException e) {
            System.out.println("Please provide valid integers!");
        }
    }
}
