import java.util.*;

public class Construct_Smallest_Number_from_DI_String {

    // Approach 1 By using permutations
    public static String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n + 1; i++) {
            sb.append((char) (i + '0'));
        }

        while (!matchesPattern(sb, pattern)) {
            nextPermutation(sb);
        }

        return sb.toString();
    }

    public static boolean matchesPattern(StringBuilder sb, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if ((pattern.charAt(i) == 'I' && sb.charAt(i) > sb.charAt(i + 1))
                    || (pattern.charAt(i) == 'D' && sb.charAt(i) < sb.charAt(i + 1))) {
                return false;
            }
        }

        return true;
    }

    public static void nextPermutation(StringBuilder sb) {
        int index = -1;

        for (int i = sb.length() - 2; i >= 0; i--) {
            if (sb.charAt(i) < sb.charAt(i + 1)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            sb.reverse();
            return;
        }

        for (int i = sb.length() - 1; i > index; i--) {
            if (sb.charAt(i) > sb.charAt(index)) {
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(index));
                sb.setCharAt(index, temp);
                reverse(sb, index + 1);
                break;
            }
        }
    }

    public static void reverse(StringBuilder sb, int left) {
        int right = sb.length() - 1;

        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    // Approach 2 Using stack
    public static String smallestNumber2(String pattern) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= pattern.length(); i++) {
            stack.push(i + 1);

            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        String pattern = "IIIDIDDD";

        System.out.println(smallestNumber(pattern));
        System.out.println(smallestNumber2(pattern));
    }
}
