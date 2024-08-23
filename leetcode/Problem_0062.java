class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int i, j;
        for (i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }
        for (j = 1; j <= n; j++) {
            dp[1][j] = 1;
        }
        for (int k = 4; k <= m + n; k++) {
            for (i = 2; i <= Math.min(k - 2, m); i++) {
                j = Math.min(k - i, n);
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}