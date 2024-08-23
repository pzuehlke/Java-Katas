class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            int q = num;
            while (q > 0) {
                int d = q % 10;
                q /= 10;
                sum += d;
            }
            num = sum;
        }
        return num;
    }
}