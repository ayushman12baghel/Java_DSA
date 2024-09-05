import java.util.*;

public class Remove_all_Adjacent_Duplicates_from_String {

    public static String removeDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (char c : str.toCharArray()) {
            if (!s.isEmpty() && s.peek() == c) {
                s.pop();
            } else {
                s.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        sb.reverse();

        return sb.toString();
    }

    public static void main(String args[]) {
        String str = "abbaca";
        System.out.println(removeDuplicate(str));
    }
}
