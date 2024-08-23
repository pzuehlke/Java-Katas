class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;  // Tracks the position to place the next non-zero element
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        // Fill remaining elements with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
