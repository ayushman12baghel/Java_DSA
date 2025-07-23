import java.util.*;

public class Maximum_Score_After_Removing_Substring {

    public static int maximumGain(String str, int x, int y) {
        int n = str.length();
        int score = 0;

        String maxStr = (x > y) ? "ab" : "ba";
        String minStr = (maxStr == "ab") ? "ba" : "ab";

        // Greedily Remove the Substring which will give me higher score after removing
        // it
        String temp_first = removeSubstrings(str, maxStr);
        int L = temp_first.length();// (score should be equal to totalLength of the string before removing)-(length
                                    // of the sunstring after removing the maxSubstring from it)
        // / length of the maxSubstring which have been removed *maxScore
        score += ((n - L) / 2 * Math.max(x, y));

        // Pass 2
        String temp_second = removeSubstrings(temp_first, minStr);
        int L2 = temp_second.length();
        score += ((L - L2) / 2 * Math.min(x, y));

        return score;
    }

    public static String removeSubstrings(String str, String pattern) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == pattern.charAt(1) && !stack.isEmpty() && stack.peek() == pattern.charAt(0)) {
                stack.pop();
            } else {
                stack.push(str.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "cdbcbbaaabab"; // ab
        int x = 4;
        int y = 5;

        System.out.println(maximumGain(str, x, y));
    }
}
