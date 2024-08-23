import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        String direction = "right";
        int m = matrix.length;
        int n = matrix[0].length;
        int min_i = 0;
        int max_i = m - 1;
        int min_j = 0;
        int max_j = n - 1;
        List<Integer> result = new ArrayList<>(m * n);
        int i = 0;
        int j = 0;

        while (min_i <= max_i && min_j <= max_j) {
            if (direction.equals("right")) {
                for (j = min_j; j <= max_j; j++) {
                    result.add(matrix[i][j]);
                }
                j--;
                min_i++;
                direction = "down";
            } else if (direction.equals("down")) {
                for (i = min_i; i <= max_i; i++) {
                    result.add(matrix[i][j]);
                }
                i--;
                max_j--;
                direction = "left";
            } else if (direction.equals("left")) {
                for (j = max_j; j >= min_j; j--) {
                    result.add(matrix[i][j]);
                }
                j++;
                max_i--;
                direction = "up";
            } else if (direction.equals("up")) {
                for (i = max_i; i >= min_i; i--) {
                    result.add(matrix[i][j]);
                }
                i++;
                min_j++;
                direction = "right";
            }
        }
        return result;
    }
}
