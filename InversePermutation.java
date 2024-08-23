public class InversePermutation {

    /**
     * Computes the inverse of a given permutation.
     *
     * The inverse permutation is such that the element at index i in the input
     * becomes the index of i in the output array.
     *
     * @param a the array representing the original permutation.
     * @return an array representing the inverse of the original permutation.
     */
    public static int[] invertPermutation(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[a[i]] = i;
        }
        return b;
    }

    public static void testInvertPermutation() {
        // Test 1:
        int[] permutation = {3, 0, 2, 1};
        int[] inverse = invertPermutation(permutation);
        System.out.println("Original permutation: ");
        printArray(permutation);
        System.out.println("Inverse permutation: ");
        printArray(inverse);
        System.out.println();

        // Test 2:
        permutation = new int[]{4, 3, 2, 1, 0};
        inverse = invertPermutation(permutation);
        System.out.println("Original permutation: ");
        printArray(permutation);
        System.out.println("Inverse permutation: ");
        printArray(inverse);
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        testInvertPermutation();
    }
}