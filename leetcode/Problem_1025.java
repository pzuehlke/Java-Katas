class Solution {
    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[1] = false;
        for (int k = 2; k <= n; k++) {
            boolean result = false;
            for (int i = 1; i < k; i++) {
                if (k % i == 0) {
                    result = result || (!dp[k - i]);
                }
            }
            dp[k] = result;
        }
        return dp[n];
    }
}