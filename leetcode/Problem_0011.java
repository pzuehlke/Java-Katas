class Problem_0011 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        int currentArea;

        while (i <= j) {
            if (height[i] <= height[j]) {
                currentArea = height[i] * (j - i);
                i++;
            }
            else {
                currentArea = height[j] * (j - i);
                j--;
            }
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }
        }
        return maxArea;
    }
}