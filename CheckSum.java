public class CheckSum {

    /**
     * Computes the checksum for a given number.
     *
     * The checksum is computed by iterating through the digits of the number.
     * For digits at even indices (0-based), the digit itself is added to the 
     * checksum. For digits at odd indices, `f(2 * digit)` is added to the 
     * checksum, where f is defined below.
     *
     * @param n The input number.
     * @return The computed checksum.
     */
    public static int getCheckSum(int n) {
        int checksum = 0;
        String nStr = Integer.toString(n);
        for (int i = 0; i < nStr.length(); i++) {
            int digit = Character.getNumericValue(nStr.charAt(i));
            if (i % 2 == 0) {
                checksum += digit;
            } else {
                checksum += f(2 * digit);
            }
        }
        return checksum;
    }

    public static int f(int n) {
        int d1 = n % 10;
        int d2 = n / 10;
        return d1 + d2;
    }

    /**
     * Generates a string representation of a number appended with its checksum.
     *
     * @param n The input number.
     * @return A string containing the original number followed by its checksum.
     */
    public static String getNumberWithChecksum(int n) {
        int checksum = getCheckSum(n);
        return n + Integer.toString(checksum);
    }

    public static void main(String[] args) {
        // Test `f` method:
        System.out.println("Testing `f` method:");
        int[] fTestValues = {12, 9, 0, 123, 45};
        for (int value : fTestValues) {
            System.out.println("f(" + value + ") = " + f(value));
        }

        // Test `getCheckSum` method:
        System.out.println("\nTesting `getCheckSum` method:");
        int[] checksumTestValues = {12345, 54321, 11111, 24680, 13579};
        for (int value : checksumTestValues) {
            System.out.println("Checksum of " + value + " = " + getCheckSum(value));
        }

        // Test `getNumberWithChecksum` method:
        System.out.println("\nTesting `getNumberWithChecksum` method:");
        int[] numberWithChecksumTestValues = {12345, 54321, 11111, 24680, 13579};
        for (int value : numberWithChecksumTestValues) {
            System.out.println("Number with checksum for " + value + " = " + 
                               getNumberWithChecksum(value));
        }
    }
}