import java.util.*;

public class Count_the_Number_of_Powerful_Numbers {

    public static long numberOfPowerfulInt(long start, long finish, String s, int limit) {
        String startStr = Long.toString(start - 1);
        String finishStr = Long.toString(finish);

        return solve(finishStr, limit, s) - solve(startStr, limit, s);
    }

    public static long solve(String str, int limit, String suffix) {
        if (str.length() < suffix.length()) {
            return 0;
        }

        String trailing = str.substring(str.length() - suffix.length());
        int prefixLength = str.length() - suffix.length();
        long count = 0;

        for (int i = 0; i < prefixLength; i++) {
            int digit = str.charAt(i) - '0';

            if (digit <= limit) {
                count += digit * Math.pow(limit + 1, prefixLength - i - 1);
            } else {
                count += Math.pow(limit + 1, prefixLength - i);
                return count;
            }
        }

        if (trailing.compareTo(suffix) >= 0) {
            count++;
        }

        return count;
    }

    public static void main(String args[]) {
        long start = 1;
        long finish = 6000;
        int limit = 4;
        String s = "124";

        System.out.println(numberOfPowerfulInt(start, finish, s, limit));
    }
}
