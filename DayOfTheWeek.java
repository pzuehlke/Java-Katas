import java.util.HashMap;
import java.util.Map;

public class DayOfTheWeek {

    /**
     * Computes the day of the week for a given date
     * using Zeller's congruence algorithm.
     *
     * @param day the day of the month (1-31).
     * @param month the month (1-12).
     * @param year the year (any integer).
     * @return the name of the day of the week.
     */
    public static String getDayOfTheWeek(int day, int month, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31 * m) / 12) % 7;

        Map<Integer, String> dayMap = new HashMap<>();
        dayMap.put(0, "Sunday");
        dayMap.put(1, "Monday");
        dayMap.put(2, "Tuesday");
        dayMap.put(3, "Wednesday");
        dayMap.put(4, "Thursday");
        dayMap.put(5, "Friday");
        dayMap.put(6, "Saturday");

        return dayMap.get(d);
    }

    /**
     * Entry point.
     * 
     * @param args CLI arguments containing the day, month, and year.
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please provide " +
                "the day, month, and year, in this order.");
            return;
        }
        int day = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        int year = Integer.parseInt(args[2]);

        String dayOfWeek = getDayOfTheWeek(day, month, year);
        System.out.println("The day of the week is: " + dayOfWeek);
    }
}