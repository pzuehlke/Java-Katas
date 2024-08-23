public class MaximumSubarrayLinear {
    public static int maxSubArray(int[] nums) {
        int left = 0;
        int right = 0;
        int pioneerLeft = 0;
        int maxSum = nums[0];
        int maxPioneerSum = nums[0];
        int n = nums.length;

        for (int k = 1; k < n; k++) {
            if (maxPioneerSum <= 0) {
                pioneerLeft = k;
                maxPioneerSum = nums[k];
            }
            else {
                maxPioneerSum += nums[k];
            }
            if (maxPioneerSum > maxSum) {
                maxSum = maxPioneerSum;
                left = pioneerLeft;
                right = k;
            }
        }
        return maxSum;
    }
    // Main method for testing the algorithm
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int result = maxSubArray(nums);
        System.out.println("Maximum subarray sum: " + result);
    }
}