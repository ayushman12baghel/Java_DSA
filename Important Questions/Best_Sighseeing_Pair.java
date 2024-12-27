import java.util.*;

public class Best_Sighseeing_Pair {

    public static int maxScoreSightseeingPair(int values[]) {
        int max = Integer.MIN_VALUE;
        int previous[] = new int[values.length];
        previous[0] = values[0];

        for (int i = 1; i < values.length; i++) {
            previous[i] = Math.max(previous[i - 1], values[i] + i);
        }

        for (int i = 1; i < values.length; i++) {
            max = Math.max(max, values[i] - i + previous[i - 1]);
        }

        return max;
    }

    // Optimised
    public static int maxScoreSightseeingPair2(int values[]) {
        int max = Integer.MIN_VALUE;
        int previous = values[0];

        for (int i = 1; i < values.length; i++) {
            max = Integer.max(max, values[i] - i + previous);
            if (previous < values[i] + i) {
                previous = values[i] + i;
            }
        }

        return max;
    }

    public static void main(String args[]) {
        int values[] = { 8, 1, 5, 2, 6 };
        System.out.println(maxScoreSightseeingPair(values));
        System.out.println(maxScoreSightseeingPair2(values));
    }
}
