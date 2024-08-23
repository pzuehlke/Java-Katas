public class FindDuplicate {

    /**
     * Checks if there is a duplicate in a given array of length n
     * whose elements are restricted to lie between 0 and n - 1.
     * 
     * @param a the array of integers to check for duplicates.
     * @return true if a duplicate exists, false otherwise.
     */
    public static boolean ThereIsDuplicate(int[] a) {
        int i = 0;
        while (i < a.length) {
            if (a[i] == i) {
                i++;
            }
            else if (a[a[i]] == a[i]) {
                return true;
            }
            else {
                int temp = a[a[i]];
                a[a[i]] = a[i];
                a[i] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            array[i] = Integer.parseInt(args[i]);
        }

        if (ThereIsDuplicate(array)) {
            System.out.println("Duplicate found.");
        } else {
            System.out.println("No duplicates found.");
        }
    }
}
