class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) { return true; }
        int lo = 2;
        int hi = Math.min(num / 2, (int) Math.pow(2, 16));
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid * mid == num) {
                return true;
            }
            else if (mid * mid > num) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return false;
    }
}