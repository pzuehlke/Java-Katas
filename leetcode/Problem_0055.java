class Solution {
    public boolean canJump(int[] nums) {
        int max_reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max_reach) {
                max_reach = Math.max(i + nums[i], max_reach);
            }
        }
        return max_reach >= nums.length - 1;
    }
}