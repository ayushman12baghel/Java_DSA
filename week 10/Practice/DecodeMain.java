import java.util.Stack;

public class DecodeMain {
    public static String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                stringStack.push(Character.toString(ch)); // Push digit char directly
            } else if (ch == '[') {
                stringStack.push(currentString.toString());
                currentString = new StringBuilder();
            } else if (ch == ']') {
                String prevString = "";
                if (!stringStack.isEmpty()) {
                    prevString = stringStack.pop();
                }
                int repeatTimes = Integer.parseInt(stringStack.pop());
                StringBuilder repeatedString = new StringBuilder();
                for (int i = 0; i < repeatTimes; i++) {
                    repeatedString.append(currentString);
                }
                currentString = new StringBuilder(prevString + repeatedString);
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        String encodedString = "3[a]2[bc]";
        System.out.println(decodeString(encodedString)); // Output: "aaabcbc"
    }
}
