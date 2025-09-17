import java.util.*;

//Approach Using 2 Stack O(n)
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            int count = 0;

            if (Character.isDigit(s.charAt(i))) {
                while (Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }

                i--;
                numStack.push(count);
            } else if (s.charAt(i) == ']') {
                count = numStack.pop();
                String temp = "";

                while (charStack.peek() != '[') {
                    temp = charStack.pop() + temp;
                }
                charStack.pop();

                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < count; j++) {
                    sb.append(temp);
                }

                for (int j = 0; j < sb.length(); j++) {
                    charStack.push(sb.charAt(j));
                }
            } else {
                charStack.push(s.charAt(i));
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!charStack.isEmpty()) {
            ans.append(charStack.pop());
        }

        return ans.reverse().toString();
    }
}