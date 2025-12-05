import java.util.*;

//O(n)
class Solution {
    public String simplifyPath(String path) {
        String words[] = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String word : words) {
            if (word.equals("") || word.equals(".")) {
                continue;
            }

            if (word.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(word);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}