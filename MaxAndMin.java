import java.util.ArrayList;

public class MaxAndMin {

    /**
     * Finds the maximum and minimum values in a list of integers.
     *
     * @param nums an ArrayList of integers from which the maximum and minimum 
     *             values are to be found
     * @return an array where the first element is the minimum value and the 
     *         second element is the maximum value in the list
     */
    public static int[] getMaxAndMin(ArrayList<Integer> nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > max) { max = n; }
            if (n < min) { min = n; }
        }
        int[] result = {min, max};
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();

        // Parse command-line arguments as integers
        for (String arg : args) {
            nums.add(Integer.parseInt(arg));
        }

        if (!nums.isEmpty()) {
            int[] maxAndMin = getMaxAndMin(nums);
            System.out.println("Minimum value: " + maxAndMin[0]);
            System.out.println("Maximum value: " + maxAndMin[1]);
        } else {
            System.out.println("No integers were provided.");
        }
    }
}