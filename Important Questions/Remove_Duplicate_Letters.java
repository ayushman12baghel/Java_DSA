import java.util.*;

public class Remove_Duplicate_Letters {

    public static String removeDuplicates(String str) {
        int lastOccurence[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            lastOccurence[str.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean taken[] = new boolean[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (taken[ch - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > ch && i < lastOccurence[stack.peek() - 'a']) {
                taken[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            taken[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

        return sb.toString();
    }

    public static void main(String args[]) {
        String str = "cbacdcbc";

        System.out.println(removeDuplicates(str));

    }
}
