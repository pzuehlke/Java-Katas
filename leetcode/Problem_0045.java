import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] min_jumps = new int[n];
        Arrays.fill(min_jumps, Integer.MAX_VALUE);
        min_jumps[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < Math.min(n - i - 1, nums[i]) + 1; j++) {
                min_jumps[i + j] = Math.min(min_jumps[i + j], 1 + min_jumps[i]);
            }
        }
        return min_jumps[n - 1];
    }
}