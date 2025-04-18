import java.util.*;

public class Count_and_Say {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String result = countAndSay(n - 1);
        StringBuilder ans = new StringBuilder("");

        for (int i = 0; i < result.length(); i++) {
            int count = 1;
            char ch = result.charAt(i);

            while (i < result.length() - 1 && result.charAt(i) == result.charAt(i + 1)) {
                count++;
                i++;
            }

            ans.append(Integer.toString(count) + ch);
        }

        return ans.toString();
    }

    public static void main(String args[]) {
        int n = 4;

        System.out.println(countAndSay(n));
    }
}
