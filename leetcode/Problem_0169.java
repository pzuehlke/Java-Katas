class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int winner = Integer.MIN_VALUE;
        for (int newCandidate : nums) {
            if (count == 0) {
                count = 1;
                winner = newCandidate;
            }
            else if (newCandidate == winner) {
                count++;
            }
            else {
                count--;
            }
        }
        return winner;
    }
}