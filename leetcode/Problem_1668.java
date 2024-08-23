class Solution {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        int j = 0;
        int i = 0;
        int count = 0;
        int maxCount = 0;

        while (i < n) {
            int oldi = i;
            while (j < m && i + j < n && sequence.charAt(i + j) == word.charAt(j)) {
                if (j == m - 1) {
                    count++;
                    maxCount = Math.max(maxCount, count);
                    i += m;
                    j = 0;
                }
                else { j++; }
            }
            i = oldi + 1;
            count = 0;
            j = 0;
        }
        return maxCount;
    }
}