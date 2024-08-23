public class MineSweeper {

    /**
     * Generates a minefield with mines placed based on a given probability.
     *
     * @param m The number of rows in the minefield.
     * @param n The number of columns in the minefield.
     * @param p The probability that a cell contains a mine.
     * @return A 2D array representing the minefield, where 1 indicates a mine
     *         and 0 indicates an empty cell.
     */
    public static int[][] generateMinefield(int m, int n, double p) {
        int[][] minefield = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.random() < p) {
                    minefield[i][j] = 1;
                } else {
                    minefield[i][j] = 0;
                }
            }
        }
        return minefield;
    }

    /**
     * Generates a field of asterisks and dots based on the minefield, where
     * asterisks represent mines and dots represent empty cells.
     *
     * @param minefield The minefield to be represented as asterisks and dots.
     * @return A 2D String array where "*" represents a mine and "." represents
     *         an empty cell.
     */
    public static String[][] generateAsteriskField(int[][] minefield) {
        int m = minefield.length;
        int n = minefield[0].length;
        String[][] asteriskField = new String[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (minefield[i][j] == 1) {
                    asteriskField[i][j] = "*";
                } else {
                    asteriskField[i][j] = ".";
                }
            }
        }
        return asteriskField;
    }

    /**
     * Generates a neighbor field from the given minefield. Each cell in the
     * neighbor field contains the number of neighboring mines.
     *
     * @param minefield The minefield to analyze.
     * @return A 2D String array where each element indicates the number of
     *         neighboring mines around the corresponding cell in the minefield.
     */
    public static String[][] generateNeighborField(int[][] minefield) {
        int m = minefield.length;
        int n = minefield[0].length;
        String[][] neighborField = new String[m][n];

        // Eight possible directions for rows and columns
        int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (minefield[i][j] == 1) {
                    neighborField[i][j] = "*"; // Marking mines with "*"
                } else {
                    int count = 0;
                    for (int d = 0; d < 8; d++) {
                        int ni = i + dRow[d];
                        int nj = j + dCol[d];
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                            count += minefield[ni][nj];
                        }
                    }
                    neighborField[i][j] = String.valueOf(count);
                }
            }
        }
        return neighborField;
    }

    /**
     * Prints a 2D String array with entries in the same row separated by a
     * single space.
     *
     * @param field The 2D String array to be printed.
     */
    public static void printField(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);          // e.g., 5
        int n = Integer.parseInt(args[1]);          // e.g., 7
        double p = Double.parseDouble(args[2]);     // e.g., 0.2

        int[][] minefield = generateMinefield(m, n, p);
        System.out.println("Minefield:");
        printField(generateAsteriskField(minefield));

        System.out.println("Neighbor Field:");
        printField(generateNeighborField(minefield));
    }
}