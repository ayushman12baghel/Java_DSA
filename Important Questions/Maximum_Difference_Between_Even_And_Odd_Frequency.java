import java.util.*;

public class Maximum_Difference_Between_Even_And_Odd_Frequency {

    public static int maxDifference(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int maxOddFreq = 1;
        int minEvenFreq = s.length();

        for (int value : map.values()) {
            if (value % 2 == 0) {
                minEvenFreq = Math.min(minEvenFreq, value);
            } else {
                maxOddFreq = Math.max(maxOddFreq, value);
            }
        }

        return maxOddFreq - minEvenFreq;
    }

    public static void main(String args[]) {
        String s = "aaaaabbc";

        System.out.println(maxDifference(s));
    }
}
