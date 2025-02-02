import java.util.Arrays;

class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) { return false; }
        List<Integer> divisors = Arrays.asList(2, 3, 5);
        for (int d : divisors) {
            while (n % d == 0) {
                n /= d;
            }
        }
        if (n == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}