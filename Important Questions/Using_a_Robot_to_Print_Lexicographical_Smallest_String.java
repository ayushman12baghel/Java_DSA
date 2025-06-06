import java.util.*;

public class Using_a_Robot_to_Print_Lexicographical_Smallest_String {

    public static String robotWithString(String s) {
        int n = s.length();
        char minCharToRight[] = new char[n];
        minCharToRight[n - 1] = s.charAt(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            minCharToRight[i] = (char) Math.min(s.charAt(i), minCharToRight[i + 1]);
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder paper = new StringBuilder();
        int i = 0;

        while (i < n) {
            stack.push(s.charAt(i));
            char minChar = (i + 1 < n) ? minCharToRight[i + 1] : s.charAt(i);

            while (!stack.isEmpty() && stack.peek() <= minChar) {
                paper.append(stack.pop());
            }

            i++;
        }

        while (!stack.isEmpty()) {
            paper.append(stack.pop());
        }

        return paper.toString();
    }

    public static void main(String args[]) {
        String str = "bdda";

        System.out.println(robotWithString(str));
    }
}
