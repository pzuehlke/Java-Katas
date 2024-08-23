class Solution {
    public int tribonacci(int n) {
        if (n == 0) { return 0; }
        if (n == 1 || n == 2) { return 1; }
        int a = 0;
        int b = 1;
        int c = 1;
        for (int k = 3; k <= n; k++) {
            int temp = c;
            c += a + b;
            a = b;
            b = temp;
        }
        return c; 
    }
}