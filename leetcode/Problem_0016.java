import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int best_distance = Integer.MAX_VALUE;
        int best_sum = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if (s == target) {
                    return target;
                }

                int current_distance = Math.abs(s - target);
                if (s < target) { j++; }
                else { k--; }
                if (current_distance < best_distance) {
                    best_distance = current_distance;
                    best_sum = s;
                }
            }
        }
        return best_sum;
    }
}