class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) == ' ') {  // Skip leading whitespace
            i++;
        }
        
        int sign = 1;  // Default sign is positive
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {  // Check for sign
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        while (i < n && s.charAt(i) == '0') {  // Skip leading zeros
            i++;
        }
        
        int result = 0;  // Result initialized to zero
        while (i < n) {
            char d = s.charAt(i);
            if (d < '0' || '9' < d) {  // Stop if character is not a digit
                break;
            }
            
            int digit = d - '0';
            // Check for overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        
        return result * sign;  // Apply sign to the result
    }
}
