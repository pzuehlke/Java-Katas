class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int result = 0;
        while (z > 0) {
            result += z % 2;
            z >>= 1;
        }
        return result;
    }
}