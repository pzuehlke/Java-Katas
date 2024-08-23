class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int i, j;

        dp[0][0] = 1 - obstacleGrid[m - 1][n - 1];
        for (i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[m - i - 1][n - 1] == 1) ? 0 : (dp[i - 1][0]);
        }
        for (j = 1; j < n; j++) {
            dp[0][j] = (obstacleGrid[m - 1][n - j - 1] == 1) ? 0 : (dp[0][j - 1]);
        }
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                dp[i][j] = (obstacleGrid[m - i - 1][n - j - 1] == 1) ? 0 : (dp[i - 1][j] + dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}