class Solution {
    public int findComplement(int num) {
        int length = 0;
        int n = num;
        while (num > 0) {
            length++;
            num >>= 1;
        }
        int bitmask = (1 << length) - 1;
        return bitmask ^ n;
    }
}