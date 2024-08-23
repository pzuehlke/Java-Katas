public class Problem_0058 {
    public static int lengthOfLastWord(String s) {
        int n = s.length();
        int i = n - 1;
        int j = 0;

        while (s.charAt(i) == ' ') {
            i --;
        }
        for (; i >=0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            else {
                j++;
            }
        }
    return j;
    }
}