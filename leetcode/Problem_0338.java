class Solution {
    public int[] countBits(int n) {
        int[] numberOfBits = new int[n + 1];
        numberOfBits[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                numberOfBits[i] = numberOfBits[i / 2];
            }
            else {
                numberOfBits[i] = 1 + numberOfBits[i / 2];
            }
        }
        return numberOfBits;
    }
}