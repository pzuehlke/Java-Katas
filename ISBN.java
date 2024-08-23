public class ISBN {
    /**
     * Computes the last digit (checksum) for a 9-digit ISBN code.
     *
     * @param code the first 9 digits of the ISBN as a String.
     * @return the complete 10-digit ISBN code including the checksum.
     */
    public static String findLastDigit(String code) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum = (sum + 
                (10 - i) * Character.getNumericValue(code.charAt(i))) % 11;
        }
        int last = 11 - sum;
        return code + ((last == 10) ? "X" : last);
    }

    public static void main(String[] args) {
        // Sample test 9-digit ISBN codes
        String[] testCodes = {"013609181", "059035342", "013110362"};
        
        for (String code : testCodes) {
            String fullISBN = findLastDigit(code);
            System.out.println("Complete ISBN for " + code + ": " + fullISBN);
        }
    }
}