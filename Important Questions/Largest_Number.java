import java.util.*;

public class Largest_Number {

    public static String largestNumber(int nums[]) {
        String s[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            result.append(s[i]);
        }

        return result.charAt(0) == '0' ? "0" : result.toString();
    }

    public static void main(String args[]) {
        int nums[] = { 3, 30, 34, 5, 9 };

        System.out.println(largestNumber(nums));

    }
}
