class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // Handle cases where one array is empty:
        if (m == 0 && n % 2 == 0) {
            return (double) (nums2[(n - 1) / 2] + nums2[(n - 1) / 2 + 1]) / 2;
        }
        if (m == 0 && n % 2 == 1) {
            return (double) nums2[(n - 1) / 2];
        }
        if (n == 0 && m % 2 == 0) {
            return (double) (nums1[(m - 1) / 2] + nums1[(m - 1) / 2 + 1]) / 2;
        }
        if (n == 0 && m % 2 == 1) {
            return (double) nums1[(m - 1) / 2];
        }
        return medianMerged(nums1, nums2);
    }


    private double medianMerged(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int size = m + n;
        int[] mergedArray = new int[size];
        int i = 0;
        int j = 0;

        for (int k = 0; k < size; k++) {
            if (i < m && (j >= n || nums1[i] < nums2[j])) {
                mergedArray[k] = nums1[i++];
            }
            else if (j < n) {
                mergedArray[k] = nums2[j++];
            }
        }
        int mid = (size - 1) / 2;
        if (size % 2 == 0) {
            return (double) (mergedArray[mid] + mergedArray[mid + 1]) / 2;
        }
        else {
            return (double) mergedArray[mid];
        }
    }
}