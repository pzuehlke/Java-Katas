/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 0;
        int hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid) == true) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        if (isBadVersion(lo) == true) {
            return lo;
        }
        else {
            return lo + 1;
        }
    }
}