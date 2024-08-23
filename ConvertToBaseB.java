import java.util.HashMap;

public class ConvertToBaseB {

    /**
     * Converts a decimal number n to a string representation in base b.
     *
     * @param n the number to convert.
     * @param b the base to convert to (between 2 and 16).
     * @return the string representation of the number in base b.
     * @throws IllegalArgumentException if the base b is not between 2 and 16.
     */
    public static String convert(long n, short b) {
        if (b < 2 || 16 < b) {
            throw new IllegalArgumentException(
                "The base b should be between 2 and 16!");
        }

        HashMap<Integer, Character> digits = new HashMap<>();
        digits.put(10, 'A');
        digits.put(11, 'B');
        digits.put(12, 'C');
        digits.put(13, 'D');
        digits.put(14, 'E');
        digits.put(15, 'F');

        String result = "";

        while (n > 0) {
            int d = (int) (n % b);
            n /= b;
            if (d >= 10) {
                result = digits.get(d) + result;
            } else {
                result = d + result;
            }
        }

        return result.isEmpty() ? "0" : result;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java ConvertToBaseB <number> <base>");
            return;
        }

        long number = Long.parseLong(args[0]);
        short base = Short.parseShort(args[1]);

        String result = convert(number, base);
        System.out.println("Number " + number + " in base " + base
            + " is: " + result);
    }
}
