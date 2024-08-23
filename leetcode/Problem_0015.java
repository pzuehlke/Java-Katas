import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Problem_0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (k < n - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                int sum = nums[j] + nums[k];
                if (sum < target) { j++; }
                else if (sum > target) { k--; }
                else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    result.add(triplet);
                    j++;
                    k--;
                 }
            }
        }
        return result;
    }
}