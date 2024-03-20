import java.util.*;

public class REverse_String_using_Stack {
    public static String ReverseString(String str) {
        Stack<Character> s = new Stack<>();
        int index = 0;
        while (index < str.length()) {
            s.push(str.charAt(index));
            index++;
        }
        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    public static void main(String args[]) {
        String str = "abc";
        System.out.println(str);
        String result = ReverseString(str);
        System.out.println(result);
    }
}
