import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] generateMatrix(int n) {
        String direction = "right";
        int min_i = 0;
        int max_i = n - 1;
        int min_j = 0;
        int max_j = n - 1;
        int[][] result = new int[n][n];
        int i = 0;
        int j = 0;
        int element = 1;

        while (min_i <= max_i && min_j <= max_j) {
            if (direction.equals("right")) {
                for (j = min_j; j <= max_j; j++) {
                    result[i][j] = element++;
                }
                j--;
                min_i++;
                direction = "down";
            } else if (direction.equals("down")) {
                for (i = min_i; i <= max_i; i++) {
                    result[i][j] = element++;
                }
                i--;
                max_j--;
                direction = "left";
            } else if (direction.equals("left")) {
                for (j = max_j; j >= min_j; j--) {
                    result[i][j] = element++;
                }
                j++;
                max_i--;
                direction = "up";
            } else if (direction.equals("up")) {
                for (i = max_i; i >= min_i; i--) {
                    result[i][j] = element++;
                }
                i++;
                min_j++;
                direction = "right";
            }
        }
        return result;
    }
}
