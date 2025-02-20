import java.util.*;

public class Find_Unique_Binary_String {

    // Approach 1 using Backtracking
    public static String findDifferentBinaryString(String nums[]) {
        Set<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }

        char arr[] = { '0', '1' };

        return solve(set, arr, new StringBuilder(), nums[0].length());
    }

    public static String solve(Set<String> set, char arr[], StringBuilder sb, int n) {
        if (sb.length() == n) {
            if (!set.contains(sb.toString())) {
                return sb.toString();
            }

            return null;
        }

        for (char c : arr) {
            sb.append(c);
            String ans = solve(set, arr, sb, n);
            if (ans != null) {
                return ans;
            }
            sb.deleteCharAt(sb.length() - 1);
        }

        return null;
    }

    // Approach 2 By making String unique by changing the character's as per the
    // Strings in nums
    public static String findDifferentBinaryString2(String nums[]) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            char c = nums[i].charAt(i);

            sb.append((c == '0' ? '1' : '0'));
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String nums[] = { "111", "011", "001" };

        System.out.println(findDifferentBinaryString(nums));
        System.out.println(findDifferentBinaryString2(nums));
    }
}
