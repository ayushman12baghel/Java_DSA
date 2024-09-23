import java.util.*;

public class Extra_Character_in_String {

    public static int extraCharacters(String s, String dict[]) {
        Set<String> set = new HashSet<>();
        for (String str : dict) {
            set.add(str);
        }
        int n = s.length();
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if (set.contains(str)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }

        return dp[n];
    }

    public static void main(String args[]) {
        String s = "sayhelloworld";
        String dict[] = { "hello", "world" };

        System.out.println(extraCharacters(s, dict));
    }
}
