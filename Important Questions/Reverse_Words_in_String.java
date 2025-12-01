import java.util.*;

//Approach 1 
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String words[] = s.split("\\s+");

        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}

// Same Approach but Difference Regex operators
class Solution {
    public String reverseWords(String s) {
        String words[] = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() != 0) {
                sb.append(words[i]);
                if (i > 0) {
                    sb.append(" ");
                }
            }
        }

        return sb.toString().trim();
    }
}