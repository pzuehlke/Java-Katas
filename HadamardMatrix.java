public class HadamardMatrix {

    /**
     * Generates a Hadamard matrix of size n x n where n is a power of 2.
     *
     * A Hadamard matrix is a a square matrix whose entries are either +1 (T)
     * or −1 (F) and whose rows are mutually orthogonal.
     * 
     * @param n The size of the matrix, which must be a power of 2.
     * @return A 2D boolean array representing the Hadamard matrix.
     * @throws IllegalArgumentException if n is not a power of 2.
     */
    public static boolean[][] makeHadamardMatrix(int n) {
        if (Integer.bitCount(n) != 1) {
            throw new IllegalArgumentException("n must be a power of 2!");
        }

        boolean[][] current = new boolean[1][1];
        current[0][0] = true;

        for (int k = 2; k <= n; k *= 2) {
            boolean[][] previous = current;
            current = new boolean[k][k];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    current[i][j] = previous[i % (k / 2)][j % (k / 2)];
                }
            }
            for (int i = 0; i < k / 2; i++) {
                for (int j = 0; j < k / 2; j++) {
                    current[i + k / 2][j + k / 2] = !previous[i][j];
                }
            }
        }

        return current;
    }

    public static void printMatrix(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] ? "T " : "F ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        try {
            boolean[][] hadamardMatrix = makeHadamardMatrix(n);
            System.out.println("Hadamard Matrix of size " + n + "x" + n + ":");
            printMatrix(hadamardMatrix);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
