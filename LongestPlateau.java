public class LongestPlateau {

    /**
     * Finds the longest contiguous sequence of equal values in an array where 
     * the values before and after the sequence are smaller.
     *
     * @param array the input array of integers to search for the longest plateau.
     * @return an array where the first element is the length of the longest plateau 
     *         and the second element is the starting index of that plateau; 
     *         returns {0, -1} if no plateau is found.
     */
    public static void main(String[] args) {
        int[] array = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            array[i] = Integer.parseInt(args[i]);
        }
        int[] result = findLongestPlateau(array);

        if (result[0] == 0) {
            System.out.println("No plateau found.");
        } else {
            System.out.println("Longest plateau length: " + result[0]);
            System.out.println("Plateau starts at index " + result[1]);
        }
    }

    public static int[] findLongestPlateau(int[] array) {
        int maxLength = 0;
        int maxStartIndex = -1;
        int n = array.length;

        for (int i = 1; i < n - 1; i++) {
            if (array[i - 1] < array[i]) { // Candidate found
                int start = i;

                // Explore the plateau as far as possible.
                while (i < n - 1 && array[i] == array[i + 1]) {
                    i++;
                }

                // Check if the plateau is valid:
                if (i < n - 1 && array[i + 1] < array[i]) {
                    int length = i - start + 1;

                    if (length > maxLength) {
                        maxLength = length;
                        maxStartIndex = start;
                    }
                }
            }
        }

        return new int[]{maxLength, maxStartIndex};
    }
}