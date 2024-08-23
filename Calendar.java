public class Calendar {

    /**
     * Determines if a given year is a leap year.
     *
     * A year is a leap year if it is divisible by 4 but not by 100, unless it is
     * also divisible by 400.
     *
     * @param year The year to check.
     * @return True if the year is a leap year, false otherwise.
     */
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0)        { return true; }
        else if (year % 100 == 0)   { return false; }
        else if (year % 4 == 0)     { return true; }
        else                        { return false; }
    }

    /**
     * Returns the number of days in a given month and year.
     *
     * @param month The month (1 = January, 2 = February, etc.).
     * @param year  The year.
     * @return The number of days in the month.
     */
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1 -> { return 31; } // January
            case 2 -> { return isLeapYear(year) ? 29 : 28; } // February
            case 3 -> { return 31; } // March
            case 4 -> { return 30; } // April
            case 5 -> { return 31; } // May
            case 6 -> { return 30; } // June
            case 7 -> { return 31; } // July
            case 8 -> { return 31; } // August
            case 9 -> { return 30; } // September
            case 10 -> { return 31; } // October
            case 11 -> { return 30; } // November
            case 12 -> { return 31; } // December
            default -> throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    /**
     * Returns the day of the week for the 1st day of a given month and year.
     *
     * @param month The month (1 = January, 2 = February, etc.).
     * @param year  The year.
     * @return The day of the week (0 = Sunday, 1 = Monday, etc.).
     */
    public static int getFirstDayOfMonth(int month, int year) {
        int y = year;
        int m = month;
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        int k = y % 100;
        int j = y / 100;
        int d = 1;
        int f = d + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j;
        return f % 7;
    }

    /**
     * Prints the calendar for a given month and year.
     *
     * @param month The month (1 = January, 2 = February, etc.).
     * @param year  The year.
     */
    public static void printCalendar(int month, int year) {
        String[] months = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        String[] days = {
            "S", "M", "T", "W", "T", "F", "S"
        };

        System.out.println(months[month] + " " + year);
        for (String day : days) {
            System.out.print(" " + day + " ");
        }
        System.out.println();

        int firstDay = getFirstDayOfMonth(month, year);
        int daysInMonth = getDaysInMonth(month, year);

        // Print leading spaces:
        for (int i = 0; i < firstDay; i++) {
            System.out.print("   ");
        }

        // Print the days of the month:
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d ", day);
            if ((firstDay + day) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Main function to parse command-line arguments and print the calendar.
     *
     * @param args Command-line arguments where args[0] is the month and args[1]
     *             is the year.
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Calendar <month> <year>");
            return;
        }

        int month;
        int year;

        try {
            month = Integer.parseInt(args[0]);
            year = Integer.parseInt(args[1]);
            if (month < 1 || month > 12) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Month must be between 1 and 12, " +
                               "and year must be a valid integer.");
            return;
        }

        printCalendar(month, year);
    }
}