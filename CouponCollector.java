public class CouponCollector {

    /**
     * Returns the number of draws needed to collect n distinct coupons.
     *
     * @param n the number of distinct coupons to collect.
     * @return the number of draws required to collect all coupons.
     */
    public static int collect(int n) {
        int draws = 0;
        int distinct = 0;
        boolean[] seen = new boolean[n];

        while (distinct < n) {
            draws++;
            int draw = (int) (n * Math.random());
            if (!seen[draw]) {
                distinct++;
                seen[draw] = true;
            }
        }
        return draws;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int draws = collect(n);
        System.out.println("Number of draws needed to collect all " +
                           n + " coupons: " + draws);
        System.out.printf("For comparison, n * log(n) is: " +
                          "%.2f\n", n * Math.log(n));
    }
}
