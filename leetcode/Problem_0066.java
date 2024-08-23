public class Problem_0066
{
    public int[] plusOne(int [] digits)
    {
        int n = digits.length;
        int carry = 1;
        int i;
        for (i = n - 1; i >= 0; i--) {
            if (carry == 0)
                break;
            else if (digits[i] == 9) {
                digits[i] = 0;
            }
            else {
                digits[i]++;
                carry = 0;
            }
        }
        if (carry == 1) {
            int[] result = new int[n + 1];
            result[0] = 1;
            for (i = 0; i < n; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
        return digits;
    }
}