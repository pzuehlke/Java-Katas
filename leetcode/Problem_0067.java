class Problem_0067 {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int l = Math.max(m, n);
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < l; i++) {
            int d1 = (i < m) ? a.charAt(m - 1 - i) - '0' : 0;
            int d2 = (i < n) ? b.charAt(n - 1 - i) - '0' : 0;
            int sum = carry + d1 + d2;
            sb.append((char) ('0' + sum % 2));
            carry = sum / 2;
        }
        if (carry == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
