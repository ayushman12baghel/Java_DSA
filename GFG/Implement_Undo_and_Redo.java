import java.util.*;

//Approach Using Stack O(1) and O(n) space
class Solution {
    StringBuilder sb = new StringBuilder();
    char prev = ' ';

    public void append(char x) {
        sb.append(x);
    }

    public void undo() {
        // undo last change
        prev = sb.charAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
    }

    public void redo() {
        // redo changes
        sb.append(prev);
        prev = ' ';
    }

    public String read() {
        // read the document

        return sb.toString();
    }
}
