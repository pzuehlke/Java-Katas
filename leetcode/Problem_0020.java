class Problem_0020 {
    public boolean isValid(String s) {
        int n = s.length();
        char[] stack = new char[n]; // Stack for opening brackets
        int j = -1; // Stack pointer

        for (int i = 0; i < n; i++) {
            char bracket = s.charAt(i);
            // Push opening brackets onto the stack:
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack[++j] = bracket;
            } else {
                // If stack is empty or top doesn't match bracket, return F:
                if (j == -1 || !matches(stack[j], bracket)) {
                    return false;
                }
                j--; // Pop the matching opening bracket from the stack
            }
        }
        return j == -1; // Check if stack is empty at the end
    }

    // Helper method to check match:
    private boolean matches(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }
}
