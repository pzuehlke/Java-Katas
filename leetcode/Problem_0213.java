class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        if (n == 1) { return nums[0]; }
        if (n <= 2) { return Math.max(nums[0], nums[1]); }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        int result = dp[n - 2];

        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        result = Math.max(result, dp[n - 1]);
        return result;
    }
}