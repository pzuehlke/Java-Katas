import java.util.ArrayList;
import java.util.HashMap;

public class Ramanujan {
    /**
     * Finds numbers that can be expressed as the
     * sum of two cubes in two different ways.
     *
     * @param n the upper bound for the values of a and b.
     * @return an ArrayList of integers that are the sums of two cubes.
     */
    public static ArrayList<Integer> findSpecial(int n) {
        HashMap<Integer, Integer> isSpecial = new HashMap<>();
        ArrayList<Integer> specialNumbers = new ArrayList<>();
        
        for (int a = 0; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                int s = a * a * a + b * b * b;
                isSpecial.put(s, isSpecial.getOrDefault(s, 0) + 1);
            }
        }
        
        for (int s : isSpecial.keySet()) {
            if (isSpecial.get(s) > 1) {
                specialNumbers.add(s);
            }
        }
        
        return specialNumbers;
    }

    public static void main(String[] args) {
        int n = 12;
        ArrayList<Integer> specialNumbers = Ramanujan.findSpecial(n);
        
        System.out.println("Special numbers up to " + n + ":");
        for (int number : specialNumbers) {
            System.out.println(number);
        }
    }
}