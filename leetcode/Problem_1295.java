class Solution {
    public int findNumbers(int[] nums) {
        int total = 0;

        for (int n : nums) {
            int digitCount = 0;
            while (n > 0) {
                digitCount++;
                n /= 10;
            }
            total = (digitCount % 2 == 0) ? total + 1 : total;
        }
        return total;
    }
}