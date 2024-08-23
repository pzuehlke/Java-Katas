public class LeapYear {

    /**
     * Determines if the given year is a leap year.
     *
     * @param year the year (any integer) to be tested.
     * @return true if the year is a leap year, false otherwise.
     */
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Entry point.
     * 
     * @param args args[0] is the year to be tested.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide " +
                "one or more years as command line arguments.");
            return;
        }

        for (String arg : args) {
            int year = Integer.parseInt(arg);
            boolean isLeap = isLeapYear(year);
            if (isLeap) {
                System.out.println("Year " + year + " is a leap year.");
            } else {
                System.out.println("Year " + year + " is not a leap year.");
            }
        }
    }
}