class Problem_0055 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0;  // Start index of the longest palindrome
        int end = 0;    // End index of the longest palindrome
        
        for (int i = 0; i < s.length(); i++) {
            // Handle odd-length palindromes:
            int len1 = expandAroundCenter(s, i, i);
            // Handle even-length palindromes:
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of the palindrome
    }
    
    public static void main(String[] args) {
        Problem_0055 solver = new Problem_0055();
        String result = solver.longestPalindrome("babad");
        System.out.println("Longest Palindromic Substring: " + result); // Example output: "bab"
    }
}
