class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean alternating = true;
        int prev = 1 - n % 2;
        do {
            int curr = n % 2;
            alternating = !(curr == prev);
            prev = curr;
            n >>= 1;
        } while (n > 0 && alternating);

        return alternating;
    }
}